package de.b4.fbc.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "food")
@NamedQuery(name = "Food.findAll",
        query = "SELECT f FROM Food f ORDER BY f.name",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "true") )
@Cacheable
public class Food {
  @Id
  @GeneratedValue(generator = "food-sequence-generator")
  @GenericGenerator(
          name = "food-sequence-generator",
          strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
          parameters = {
                  @org.hibernate.annotations.Parameter(name = "sequence_name", value = "food_sequence"),
                  @org.hibernate.annotations.Parameter(name = "initial_value", value = "10000"),
                  @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
          }
  )
  private Integer id;
  private String name;
  private String brand;
  private String barcode;
  private String link;
  private Double calories;
  private Double protein;
  private Double carbohydrates;
  private Double fat;
  private String imageUrl;
  private String imageSmallUrl;
  private String imageThumbUrl;

  public Food() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public Double getCalories() {
    return calories;
  }

  public void setCalories(Double calories) {
    this.calories = calories;
  }

  public Double getProtein() {
    return protein;
  }

  public void setProtein(Double protein) {
    this.protein = protein;
  }

  public Double getCarbohydrates() {
    return carbohydrates;
  }

  public void setCarbohydrates(Double carbohydrates) {
    this.carbohydrates = carbohydrates;
  }

  public Double getFat() {
    return fat;
  }

  public void setFat(Double fat) {
    this.fat = fat;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getImageSmallUrl() {
    return imageSmallUrl;
  }

  public void setImageSmallUrl(String imageSmallUrl) {
    this.imageSmallUrl = imageSmallUrl;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getImageThumbUrl() {
    return imageThumbUrl;
  }

  public void setImageThumbUrl(String imageThumbUrl) {
    this.imageThumbUrl = imageThumbUrl;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Food)) {
      return false;
    }

    Food other = (Food) obj;

    return Objects.equals(other.name, this.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name);
  }
}
