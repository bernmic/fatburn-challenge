package de.b4.fbc.service;

import javax.enterprise.context.ApplicationScoped;

import de.b4.fbc.model.Plan;
import de.b4.fbc.model.Target;

@ApplicationScoped
public class TargetService {

    public Target getTarget(Integer day, Plan theplan, Boolean noTraining) {
        if (day < 1 || day > plan.length || theplan.getWeight() == 0) {
            return null;
        }
        Target t = new Target();
        t.setDay(day);
        t.setDate(theplan.getStartDate().plusDays(day));
        t.setUser(theplan.getUser());
        t.setWeight(theplan.getWeight());
        if (noTraining != null && noTraining == true) {
            t.setProtein(noTrainingDay.protein * theplan.getWeight());
            t.setCarbohydrates(noTrainingDay.carbonate * theplan.getWeight());
            t.setFat(noTrainingDay.fat * theplan.getWeight());
        }
        else {
            t.setProtein(plan[day - 1].protein * theplan.getWeight());
            t.setCarbohydrates(plan[day - 1].carbonate * theplan.getWeight());
            t.setFat(plan[day - 1].fat * theplan.getWeight());
        }
        return t;
    }

    public Target[] getAllTargets(Plan theplan) {
        Target[] targets = new Target[30];
        for (int i = 0; i < plan.length; i++) {
            targets[i] = getTarget(i + 1, theplan, false);
        }
        return targets;
    }

    static TargetValues noTrainingDay = new TargetValues(2.2, 0.5, 1.0);

    static TargetValues[] plan = {
        // Day 1 to 7
        new TargetValues(2.2, 2.0, 1.0),
        new TargetValues(2.2, 2.0, 1.0),
        new TargetValues(2.2, 2.0, 1.0),
        new TargetValues(2.2, 2.0, 1.0),
        new TargetValues(2.2, 2.0, 1.0),
        new TargetValues(2.2, 2.0, 1.0),
        new TargetValues(2.2, 2.0, 1.0),
        // Day 8
        new TargetValues(2.2, 4.0, 0.0),
        // Day 9 to 15
        new TargetValues(2.2, 1.0, 0.8),
        new TargetValues(2.2, 1.0, 0.8),
        new TargetValues(2.2, 1.0, 0.8),
        new TargetValues(2.2, 1.0, 0.8),
        new TargetValues(2.2, 1.0, 0.8),
        new TargetValues(2.2, 1.0, 0.8),
        new TargetValues(2.2, 1.0, 0.8),
        // Day 16
        new TargetValues(2.2, 4.0, 0.0),
        // Day 17 to 30
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5),
        new TargetValues(2.2, 1.0, 0.5)
    };

    public static class TargetValues {
        private final Double protein;
        private final Double carbonate;
        private final Double fat;
        
        public TargetValues(Double protein, Double carbonate, Double fat) {
            this.protein = protein;
            this.carbonate = carbonate;
            this.fat = fat;
        }

        public Double getProtein() {
            return protein;
        }

        public Double getCarbonate() {
            return carbonate;
        }

        public Double getFat() {
            return fat;
        }
    }
}