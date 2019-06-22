package de.b4.fbc.restclient.openfoodfacts.service;

import de.b4.fbc.restclient.openfoodfacts.model.ProductList;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@ApplicationScoped
public class ProductService {
  private final String restUrl = "https://world.openfoodfacts.org/cgi";

  public ProductList searchProducts(String searchItem, int page) {
    try {
      ResteasyClient client = new ResteasyClientBuilderImpl().build();
      ResteasyWebTarget target = client.target(restUrl + "/search.pl?search_simple=1&json=1&action=process&search_terms=" + URLEncoder.encode(searchItem, "UTF-8") + "&page=" + page);
      Response response = target.request().get();
      ProductList p = response.readEntity(ProductList.class);
      response.close();
      return p;
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }
}
