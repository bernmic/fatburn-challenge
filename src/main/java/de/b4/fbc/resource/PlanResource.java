package de.b4.fbc.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import de.b4.fbc.model.Target;
import de.b4.fbc.model.Plan;
import de.b4.fbc.service.PlanService;
import de.b4.fbc.service.TargetService;

@Path("/plan")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class PlanResource {

    @Inject
    PlanService planService;

    @Inject
    TargetService targetService;

    @GET
    public Plan[] getPlans() {
        return planService.getPlans();
    }

    @GET
    @Path("{id}")
    public Plan getPlan(@PathParam("id") Integer id) {
        Plan entity = planService.getById(id);
        if (entity == null) {
            throw new WebApplicationException("Plan with id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    @POST
    public Response createPlan(Plan plan) {
        if (plan.getId() != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }
        plan = planService.createPlan(plan);
        return Response.ok(plan).status(201).build();
    }

    @GET
    @Path("{id}/target/{day}")
    public Target getTarget(@PathParam("id") Integer id, @PathParam("day") Integer day, @QueryParam("noTraining") Boolean noTraining) {
        Plan entity = planService.getById(id);
        if (entity == null) {
            throw new WebApplicationException("Plan with id of " + id + " does not exist.", 404);
        }
        Target target = targetService.getTarget(day, entity, noTraining);
        if (target == null) {
            throw new WebApplicationException("Illegal arguments.", 400);
        }
        return target;
    }

    @GET
    @Path("{id}/targets")
    public Target[] getAllTarget(@PathParam("id") Integer id) {
        Plan entity = planService.getById(id);
        if (entity == null) {
            throw new WebApplicationException("Plan with id of " + id + " does not exist.", 404);
        }
        Target[] targets = targetService.getAllTargets(entity);
        return targets;
    }
}