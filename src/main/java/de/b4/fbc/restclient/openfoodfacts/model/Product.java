package de.b4.fbc.restclient.openfoodfacts.model;

import org.apache.commons.text.StringEscapeUtils;

import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
  @JsonbProperty("generic_name")
  private String genericName;

  @JsonbProperty("product_name")
  private String productName;

  public String getGenericName() {
    return genericName;
  }

  public void setGenericName(String genericName) {
    this.genericName = genericName;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }
}

/*
public class Product {
  private static final long serialVersionUID = 1L;
  @JsonbProperty("image_small_url")
  private String imageSmallUrl;
  @JsonbProperty("image_nutrition_url")
  private String imageNutritionUrl;
  @JsonbProperty("image_front_url")
  private String imageFrontUrl;
  @JsonbProperty("image_ingredients_url")
  private String imageIngredientsUrl;
  @JsonbProperty("link")
  private String manufactureUrl;
  @JsonbProperty("url")
  private String url;
  @JsonbProperty("code")
  private String code;
  @JsonbProperty("traces_tags")
  private List<String> tracesTags = new ArrayList<>();
  @JsonbProperty("ingredients_that_may_be_from_palm_oil_tags")
  private List<String> ingredientsThatMayBeFromPalmOilTags = new ArrayList<>();
  @JsonbProperty("additives_tags")
  private List<String> additivesTags = new ArrayList<>();
  @JsonbProperty("allergens_hierarchy")
  private List<String> allergensHierarchy = new ArrayList<>();
  @JsonbProperty("manufacturing_places")
  private String manufacturingPlaces;
  //private Nutriments nutriments;
  @JsonbProperty("ingredients_from_palm_oil_tags")
  private List<Object> ingredientsFromPalmOilTags = new ArrayList<>();
  @JsonbProperty("brands_tags")
  private List<String> brandsTags = new ArrayList<>();
  private String traces;
  @JsonbProperty("categories_tags")
  private List<String> categoriesTags;
  @JsonbProperty("ingredients_text")
  @JsonbTypeAdapter(ProductStringAdapter.class)
  private String ingredientsText;
  @JsonbProperty("product_name")
  @JsonbTypeAdapter(ProductStringAdapter.class)
  private String productName;
  @JsonbProperty("generic_name")
  @JsonbTypeAdapter(ProductStringAdapter.class)
  private String genericName;
  @JsonbProperty("ingredients_from_or_that_may_be_from_palm_oil_n")
  private long ingredientsFromOrThatMayBeFromPalmOilN;
  @JsonbProperty("serving_size")
  private String servingSize;
  @JsonbProperty("last_modified_by")
  private String lastModifiedBy;
  @JsonbProperty("allergens_tags")
  private List<String> allergensTags;
  private String allergens;
  private String origins;
  private String stores;
  @JsonbProperty("nutrition_grade_fr")
  private String nutritionGradeFr;
  private String countries;
  @JsonbProperty("countries_tags")
  private List<String> countriesTags;
  private String brands;
  private String packaging;
  @JsonbProperty("labels_hierarchy")
  private List<String> labelsHierarchy;
  @JsonbProperty("labels_tags")
  private List<String> labelsTags;
  @JsonbProperty("cities_tags")
  private List<Object> citiesTags = new ArrayList<>();
  private String quantity;
  @JsonbProperty("ingredients_from_palm_oil_n")
  private long ingredientsFromPalmOilN;
  @JsonbProperty("image_url")
  private String imageUrl;
  @JsonbProperty("emb_codes_tags")
  private List<Object> embTags = new ArrayList<>();
  @JsonbProperty("states_tags")
  private List<String> statesTags = new ArrayList<>();
  @JsonbProperty("vitamins_tags")
  private List<String> vitaminTags = new ArrayList<>();
  @JsonbProperty("minerals_tags")
  private List<String> mineralTags = new ArrayList<>();
  @JsonbProperty("amino_acids_tags")
  private List<String> aminoAcidTags = new ArrayList<>();
  @JsonbProperty("other_nutritional_substances_tags")
  private List<String> otherNutritionTags = new ArrayList<>();
  @JsonbProperty("created_t")
  private String createdDateTime;
  @JsonbProperty("creator")
  private String creator;
  @JsonbProperty("last_modified_t")
  private String lastModifiedTime;
  @JsonbProperty("editors_tags")
  private List<String> editorsTags = new ArrayList<>();
  @JsonbProperty("nova_groups")
  private String novaGroups;
  @JsonbProperty("environment_impact_level_tags")
  private List<String> environmentImpactLevelTags;
  @JsonbProperty("lang")
  private String lang;
  @JsonbProperty("purchase_places")
  private String purchasePlaces;
  @JsonbProperty("nutrition_data_per")
  private String nutritionDataPer;
  @JsonbProperty("no_nutrition_data")
  private String noNutritionData;
  @JsonbProperty("other_information")
  private String otherInformation;
  @JsonbProperty("conservation_conditions")
  private String conservationConditions;
  @JsonbProperty("recycling_instructions_to_discard")
  private String recyclingInstructionsToDiscard;
  @JsonbProperty("recycling_instructions_to_recycle")
  private String recyclingInstructionsToRecycle;
  @JsonbProperty("warning")
  private String warning;
  @JsonbProperty("customer_service")
  private String customerService;
  @JsonbProperty("environment_infocard")
  private String environmentInfocard;
  private Map<String, Object> additionalProperties = new HashMap<>();

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getImageSmallUrl() {
    return imageSmallUrl;
  }

  public void setImageSmallUrl(String imageSmallUrl) {
    this.imageSmallUrl = imageSmallUrl;
  }

  public String getImageNutritionUrl() {
    return imageNutritionUrl;
  }

  public void setImageNutritionUrl(String imageNutritionUrl) {
    this.imageNutritionUrl = imageNutritionUrl;
  }

  public String getImageFrontUrl() {
    return imageFrontUrl;
  }

  public void setImageFrontUrl(String imageFrontUrl) {
    this.imageFrontUrl = imageFrontUrl;
  }

  public String getImageIngredientsUrl() {
    return imageIngredientsUrl;
  }

  public void setImageIngredientsUrl(String imageIngredientsUrl) {
    this.imageIngredientsUrl = imageIngredientsUrl;
  }

  public String getManufactureUrl() {
    return manufactureUrl;
  }

  public void setManufactureUrl(String manufactureUrl) {
    this.manufactureUrl = manufactureUrl;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<String> getTracesTags() {
    return tracesTags;
  }

  public void setTracesTags(List<String> tracesTags) {
    this.tracesTags = tracesTags;
  }

  public List<String> getIngredientsThatMayBeFromPalmOilTags() {
    return ingredientsThatMayBeFromPalmOilTags;
  }

  public void setIngredientsThatMayBeFromPalmOilTags(List<String> ingredientsThatMayBeFromPalmOilTags) {
    this.ingredientsThatMayBeFromPalmOilTags = ingredientsThatMayBeFromPalmOilTags;
  }

  public List<String> getAdditivesTags() {
    return additivesTags;
  }

  public void setAdditivesTags(List<String> additivesTags) {
    this.additivesTags = additivesTags;
  }

  public List<String> getAllergensHierarchy() {
    return allergensHierarchy;
  }

  public void setAllergensHierarchy(List<String> allergensHierarchy) {
    this.allergensHierarchy = allergensHierarchy;
  }

  public String getManufacturingPlaces() {
    return manufacturingPlaces;
  }

  public void setManufacturingPlaces(String manufacturingPlaces) {
    this.manufacturingPlaces = manufacturingPlaces;
  }

  public Nutriments getNutriments() {
    return nutriments;
  }

  public void setNutriments(Nutriments nutriments) {
    this.nutriments = nutriments;
  }

  public List<Object> getIngredientsFromPalmOilTags() {
    return ingredientsFromPalmOilTags;
  }

  public void setIngredientsFromPalmOilTags(List<Object> ingredientsFromPalmOilTags) {
    this.ingredientsFromPalmOilTags = ingredientsFromPalmOilTags;
  }

  public List<String> getBrandsTags() {
    return brandsTags;
  }

  public void setBrandsTags(List<String> brandsTags) {
    this.brandsTags = brandsTags;
  }

  public String getTraces() {
    return traces;
  }

  public void setTraces(String traces) {
    this.traces = traces;
  }

  public List<String> getCategoriesTags() {
    return categoriesTags;
  }

  public void setCategoriesTags(List<String> categoriesTags) {
    this.categoriesTags = categoriesTags;
  }

  public String getIngredientsText() {
    return ingredientsText;
  }

  public void setIngredientsText(String ingredientsText) {
    this.ingredientsText = ingredientsText;
  }
/*
  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getGenericName() {
    return genericName;
  }

  public void setGenericName(String genericName) {
    this.genericName = genericName;
  }

  public long getIngredientsFromOrThatMayBeFromPalmOilN() {
    return ingredientsFromOrThatMayBeFromPalmOilN;
  }

  public void setIngredientsFromOrThatMayBeFromPalmOilN(long ingredientsFromOrThatMayBeFromPalmOilN) {
    this.ingredientsFromOrThatMayBeFromPalmOilN = ingredientsFromOrThatMayBeFromPalmOilN;
  }

  public String getServingSize() {
    return servingSize;
  }

  public void setServingSize(String servingSize) {
    this.servingSize = servingSize;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public List<String> getAllergensTags() {
    return allergensTags;
  }

  public void setAllergensTags(List<String> allergensTags) {
    this.allergensTags = allergensTags;
  }

  public String getAllergens() {
    return allergens;
  }

  public void setAllergens(String allergens) {
    this.allergens = allergens;
  }

  public String getOrigins() {
    return origins;
  }

  public void setOrigins(String origins) {
    this.origins = origins;
  }

  public String getStores() {
    return stores;
  }

  public void setStores(String stores) {
    this.stores = stores;
  }

  public String getNutritionGradeFr() {
    return nutritionGradeFr;
  }

  public void setNutritionGradeFr(String nutritionGradeFr) {
    this.nutritionGradeFr = nutritionGradeFr;
  }

  public String getCountries() {
    return countries;
  }

  public void setCountries(String countries) {
    this.countries = countries;
  }

  public List<String> getCountriesTags() {
    return countriesTags;
  }

  public void setCountriesTags(List<String> countriesTags) {
    this.countriesTags = countriesTags;
  }

  public String getBrands() {
    return brands;
  }

  public void setBrands(String brands) {
    this.brands = brands;
  }

  public String getPackaging() {
    return packaging;
  }

  public void setPackaging(String packaging) {
    this.packaging = packaging;
  }

  public List<String> getLabelsHierarchy() {
    return labelsHierarchy;
  }

  public void setLabelsHierarchy(List<String> labelsHierarchy) {
    this.labelsHierarchy = labelsHierarchy;
  }

  public List<String> getLabelsTags() {
    return labelsTags;
  }

  public void setLabelsTags(List<String> labelsTags) {
    this.labelsTags = labelsTags;
  }

  public List<Object> getCitiesTags() {
    return citiesTags;
  }

  public void setCitiesTags(List<Object> citiesTags) {
    this.citiesTags = citiesTags;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public long getIngredientsFromPalmOilN() {
    return ingredientsFromPalmOilN;
  }

  public void setIngredientsFromPalmOilN(long ingredientsFromPalmOilN) {
    this.ingredientsFromPalmOilN = ingredientsFromPalmOilN;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public List<Object> getEmbTags() {
    return embTags;
  }

  public void setEmbTags(List<Object> embTags) {
    this.embTags = embTags;
  }

  public List<String> getStatesTags() {
    return statesTags;
  }

  public void setStatesTags(List<String> statesTags) {
    this.statesTags = statesTags;
  }

  public List<String> getVitaminTags() {
    return vitaminTags;
  }

  public void setVitaminTags(List<String> vitaminTags) {
    this.vitaminTags = vitaminTags;
  }

  public List<String> getMineralTags() {
    return mineralTags;
  }

  public void setMineralTags(List<String> mineralTags) {
    this.mineralTags = mineralTags;
  }

  public List<String> getAminoAcidTags() {
    return aminoAcidTags;
  }

  public void setAminoAcidTags(List<String> aminoAcidTags) {
    this.aminoAcidTags = aminoAcidTags;
  }

  public List<String> getOtherNutritionTags() {
    return otherNutritionTags;
  }

  public void setOtherNutritionTags(List<String> otherNutritionTags) {
    this.otherNutritionTags = otherNutritionTags;
  }

  public String getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(String createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getLastModifiedTime() {
    return lastModifiedTime;
  }

  public void setLastModifiedTime(String lastModifiedTime) {
    this.lastModifiedTime = lastModifiedTime;
  }

  public List<String> getEditorsTags() {
    return editorsTags;
  }

  public void setEditorsTags(List<String> editorsTags) {
    this.editorsTags = editorsTags;
  }

  public String getNovaGroups() {
    return novaGroups;
  }

  public void setNovaGroups(String novaGroups) {
    this.novaGroups = novaGroups;
  }

  public List<String> getEnvironmentImpactLevelTags() {
    return environmentImpactLevelTags;
  }

  public void setEnvironmentImpactLevelTags(List<String> environmentImpactLevelTags) {
    this.environmentImpactLevelTags = environmentImpactLevelTags;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public String getPurchasePlaces() {
    return purchasePlaces;
  }

  public void setPurchasePlaces(String purchasePlaces) {
    this.purchasePlaces = purchasePlaces;
  }

  public String getNutritionDataPer() {
    return nutritionDataPer;
  }

  public void setNutritionDataPer(String nutritionDataPer) {
    this.nutritionDataPer = nutritionDataPer;
  }

  public String getNoNutritionData() {
    return noNutritionData;
  }

  public void setNoNutritionData(String noNutritionData) {
    this.noNutritionData = noNutritionData;
  }

  public String getOtherInformation() {
    return otherInformation;
  }

  public void setOtherInformation(String otherInformation) {
    this.otherInformation = otherInformation;
  }

  public String getConservationConditions() {
    return conservationConditions;
  }

  public void setConservationConditions(String conservationConditions) {
    this.conservationConditions = conservationConditions;
  }

  public String getRecyclingInstructionsToDiscard() {
    return recyclingInstructionsToDiscard;
  }

  public void setRecyclingInstructionsToDiscard(String recyclingInstructionsToDiscard) {
    this.recyclingInstructionsToDiscard = recyclingInstructionsToDiscard;
  }

  public String getRecyclingInstructionsToRecycle() {
    return recyclingInstructionsToRecycle;
  }

  public void setRecyclingInstructionsToRecycle(String recyclingInstructionsToRecycle) {
    this.recyclingInstructionsToRecycle = recyclingInstructionsToRecycle;
  }

  public String getWarning() {
    return warning;
  }

  public void setWarning(String warning) {
    this.warning = warning;
  }

  public String getCustomerService() {
    return customerService;
  }

  public void setCustomerService(String customerService) {
    this.customerService = customerService;
  }

  public String getEnvironmentInfocard() {
    return environmentInfocard;
  }

  public void setEnvironmentInfocard(String environmentInfocard) {
    this.environmentInfocard = environmentInfocard;
  }
}
*/