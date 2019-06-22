package de.b4.fbc.restclient.openfoodfacts.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class ProductList {
  private int page;
  private int count;
  @JsonbProperty(value = "page_size")
  private int pageSize;
  private int skip;
  private List<Product> products;

  @JsonbCreator
  public ProductList(
          @JsonbProperty("page") String page,
          @JsonbProperty("count") int count,
          @JsonbProperty("page_size") String pageSize,
          @JsonbProperty("skip") int skip,
          @JsonbProperty("products") List<Product> products
  ) {
    this.count = count;
    this.skip = skip;
    this.page = Integer.parseInt(page);
    this.pageSize = Integer.parseInt(pageSize);
    this.products = products;
  }

  public int getPage() {
    return page;
  }

  public int getCount() {
    return count;
  }

  public int getPageSize() {
    return pageSize;
  }

  public int getSkip() {
    return skip;
  }

  public List<Product> getProducts() {
    return products;
  }
}
