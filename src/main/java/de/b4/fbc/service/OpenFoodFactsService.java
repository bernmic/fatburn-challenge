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
    f.setBrand(p.getString("brands"));
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

}
