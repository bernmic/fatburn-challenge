package de.b4.fbc.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import de.b4.fbc.model.Food;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

@ApplicationScoped
public class OpenFoodFactsService {
  private static Logger log = LoggerFactory.getLogger(OpenFoodFactsService.class);

  @Inject
  MongoDBService mongoDBService;

  private MongoDatabase productsDatabase;
  private MongoCollection<Document> productsCollection;

  public Food findFoodByCode(String code) {
    initDB();
    return convertFood(productsCollection.find(eq("code", code)).first());
  }

  public Food[] searchFood(String query) {
    initDB();
    FindIterable<Document> fiter = productsCollection.find(
      and(
        text(query),
        or(
          regex("product_name", ".*" + query + ".*"),
          regex("generic_name", ".*" + query + ".*")
        )
      )
    ).limit(50);

    MongoCursor<Document> it = fiter.iterator();
    List<Food> foods = new ArrayList<>();
    while (it.hasNext()) {
      Food f = convertFood(it.next());
      foods.add(f);
    }

    log.info(String.format("Found %d products for criteria >>%s<<", foods.size(), query));
    return foods.toArray(new Food[0]);
  }

  // db.products.createIndex( { product_name: "text", generic_name: "text" } );

  private void initDB() {
    if (productsDatabase == null) {
      productsDatabase = mongoDBService.getDatabase("off");
      productsCollection = productsDatabase.getCollection("products");
    }
  }

  private Food convertFood(Document p) {
    if (p == null) {
      return null;
    }
    Food f = new Food();
    f.setBarcode(p.getString("code"));
    f.setName(p.getString("product_name"));
    if (f.getName() == null || f.getName().length() == 0) {
      f.setName(p.getString("generic_name"));
    }
    log.info("image_url = " + p.getString("image_url"));
    f.setBrand(p.getString("brands"));
    f.setLink(p.getString("link"));
    f.setImageUrl(createImageUrl(p, "400"));
    f.setImageSmallUrl(createImageUrl(p, "200"));
    f.setImageThumbUrl(createImageUrl(p, "100"));

    if (p.containsKey("nutriments")) {
      Document n = (Document)p.get("nutriments");
      if (n.containsKey("energy_100g")) {
        f.setCalories(getAsDouble(n.get("energy_100g")));
        f.setCalories(f.getCalories() / 4.184);
      }
      if (n.containsKey("proteins_100g")) {
        f.setProtein(getAsDouble(n.get("proteins_100g")));
      }
      if (n.containsKey("carbohydrates_100g")) {
        f.setCarbohydrates(getAsDouble(n.get("carbohydrates_100g")));
      }
      if (n.containsKey("fat_100g")) {
        f.setFat(getAsDouble(n.get("fat_100g")));
      }
    }
    return f;
  }

  private Double getAsDouble(Object o) {
    return o instanceof Double ? (Double)o : new Double((Integer)o);
  }

  private String createImageUrl(Document p, String size) {
    if (!p.containsKey("images")) {
      return null;
    }
    String code = p.getString("code");
    String url = "https://static.openfoodfacts.org/images/products/";
    Document images = (Document)p.get("images");
    if (code != null) {
      if (code.length() == 13) {
        url += (code.substring(0,3) + "/" + code.substring(3,6) + "/" + code.substring(6,9) + "/" + code.substring(9) + "/");
      }
      else {
        url += (code + "/");
      }
      String front = getFrontImage(images, size);
      if (front != null) {
        return url + front;
      }
    }
    return null;
  }

  private String getFrontImage(Document images, String size) {
    String result = "";
    Document front = null;
    if (images.containsKey("front_de")) {
      result += "front_de.";
      front = (Document) images.get("front_de");
    }
    else if (images.containsKey("front")) {
      result += "front.";
      front = (Document) images.get("front");
    }
    else if (images.containsKey("front_en")) {
      result += "front_en.";
      front = (Document) images.get("front_en");
    }
    else if (images.containsKey("front_fr")) {
      result += "front_fr.";
      front = (Document) images.get("front_fr");
    }
    else {
      return null;
    }

    if (front != null) {
      result += (front.getString("rev") + "." + size + ".jpg");
    }
    return result;
  }
}
