package de.b4.fbc.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.xml.ws.Response;

import de.b4.fbc.model.Plan;
import io.agroal.api.AgroalDataSource;

@ApplicationScoped
public class PlanService {
    @Inject
    AgroalDataSource defaultDataSource;
    
    @Inject
    EntityManager em;

    public Plan[] getPlans() {
        return em.createNamedQuery("Plan.findAll", Plan.class).getResultList().toArray(new Plan[0]);
    }

    public Plan getById(Integer id) {
        return em.find(Plan.class, id);
    }

    @Transactional
    public Plan createPlan(Plan plan) {

        em.persist(plan);
        return plan;
    }
}