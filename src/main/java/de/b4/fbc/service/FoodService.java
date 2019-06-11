package de.b4.fbc.service;

import de.b4.fbc.model.Food;
import io.agroal.api.AgroalDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FoodService {
    @Inject
    AgroalDataSource defaultDataSource;
    
    @Inject
    EntityManager em;

    public Food[] getFoods() {
        return em.createNamedQuery("Food.findAll", Food.class).getResultList().toArray(new Food[0]);
    }

    public Food getById(Integer id) {
        return em.find(Food.class, id);
    }

    public Food[] findFoodByName(String name) {
        Query query = em.createQuery("SELECT f FROM Food f WHERE f.name LIKE :filter");
        query.setParameter("filter", name);
        List<Food> result = query.getResultList();
        return result.toArray(new Food[0]);
    }

    @Transactional
    public Food createPlan(Food food) {

        em.persist(food);
        return food;
    }
}