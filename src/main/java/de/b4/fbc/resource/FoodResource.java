package de.b4.fbc.resource;

import de.b4.fbc.model.Food;
import de.b4.fbc.service.FoodService;
import de.b4.fbc.service.OpenFoodFactsService;
import org.apache.commons.lang3.ArrayUtils;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/food")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class FoodResource {

  @Inject
  FoodService foodService;

  @Inject
  OpenFoodFactsService openFoodFactsService;

  @GET
  public Food[] getFoods(@QueryParam("filter") String filter) {
    if (filter == null || filter.length() == 0) {
      return foodService.getFoods();
    }
    Food[] internalFoods = foodService.findFoodByName(filter);
    if (filter == null || filter.length() == 0) {
      return internalFoods;
    }
    Food[] externalFoods = openFoodFactsService.searchFood(filter);
    return ArrayUtils.addAll(internalFoods, externalFoods);
  }

  @GET
  @Path("{id}")
  public Food getFood(@PathParam("id") String id) {
    Food entity = null;
    try  {
      entity = foodService.getById(Integer.parseInt(id));
    } catch (NumberFormatException e) {}

    if (entity == null) {
      entity = openFoodFactsService.findFoodByCode(id.toString());
      if (entity == null) {
        throw new WebApplicationException("Food with id of " + id + " does not exist.", 404);
      }
    }
    return entity;
  }

  @POST
  public Response createFood(Food food) {
    if (food.getId() != null) {
      throw new WebApplicationException("Id was invalidly set on request.", 422);
    }
    food = foodService.createPlan(food);
    return Response.ok(food).status(201).build();
  }

}
