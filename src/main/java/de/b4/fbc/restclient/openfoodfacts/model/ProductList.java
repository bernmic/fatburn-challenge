package de.b4.fbc.restclient.openfoodfacts.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class ListWrapper<T> {
  private int page;
  private int count;
  @JsonbProperty(value = "page_size")
  private int pageSize;
  private int skip;

  @JsonbCreator
  public ListWrapper(
          @JsonbProperty("page") String page,
          @JsonbProperty("count") int count,
          @JsonbProperty("page_size") String pageSize,
          @JsonbProperty("skip") int skip
  ) {
    this.count = count;
    this.skip = skip;
    this.page = Integer.parseInt(page);
    this.pageSize = Integer.parseInt(pageSize);
  }
}
