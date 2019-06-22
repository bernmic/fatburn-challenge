package de.b4.fbc.restclient.openfoodfacts.service;

import de.b4.fbc.restclient.openfoodfacts.model.ProductList;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@RegisterRestClient
public interface ProductService {
  @GET
  @Path("/search.pl?search_simple=1&json=1&action=process")
  @Produces("application/json")
  ProductList getProductList(@QueryParam("search_terms") String name, @QueryParam("page") int page);
}
