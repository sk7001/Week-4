import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    void displayMeal();
    boolean isValid();
}

class VegetarianMeal implements MealPlan {
    String name;
    VegetarianMeal(String name) { this.name = name; }
    @Override public void displayMeal() { System.out.println("Vegetarian Meal: " + name); }
    @Override public boolean isValid() { return !name.toLowerCase().contains("meat"); }
}

class VeganMeal implements MealPlan {
    String name;
    VeganMeal(String name) { this.name = name; }
    @Override public void displayMeal() { System.out.println("Vegan Meal: " + name); }
    @Override public boolean isValid() { return !name.toLowerCase().contains("meat") && !name.toLowerCase().contains("milk"); }
}

class KetoMeal implements MealPlan {
    String name;
    KetoMeal(String name) { this.name = name; }
    @Override public void displayMeal() { System.out.println("Keto Meal: " + name); }
    @Override public boolean isValid() { return !name.toLowerCase().contains("sugar"); }
}

class HighProteinMeal implements MealPlan {
    String name;
    HighProteinMeal(String name) { this.name = name; }
    @Override public void displayMeal() { System.out.println("High-Protein Meal: " + name); }
    @Override public boolean isValid() {
        return name.toLowerCase().contains("egg") || name.toLowerCase().contains("chicken") || name.toLowerCase().contains("protein");
    }
}

class Meal<T extends MealPlan> {
    List<T> mealList = new ArrayList<>();
    void addMeal(T meal) {
        if (meal.isValid()) mealList.add(meal);
        else System.out.println("Invalid meal: " + meal.getClass().getSimpleName());
    }
    void showMeals() { for (T meal : mealList) meal.displayMeal(); }
    static <T extends MealPlan> void generatePersonalizedMeal(T meal) {
        if (meal.isValid()) {
            System.out.println("Generated Meal Plan:");
            meal.displayMeal();
        } else {
            System.out.println("Cannot generate meal plan. Invalid meal: " + meal.getClass().getSimpleName());
        }
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Meal<VeganMeal> veganPlan = new Meal<>();
        veganPlan.addMeal(new VeganMeal("Tofu Salad"));
        veganPlan.addMeal(new VeganMeal("Vegan Burger"));
        veganPlan.addMeal(new VeganMeal("Milk Smoothie"));

        Meal<HighProteinMeal> proteinPlan = new Meal<>();
        proteinPlan.addMeal(new HighProteinMeal("Boiled Eggs"));
        proteinPlan.addMeal(new HighProteinMeal("Protein Shake"));

        System.out.println("Vegan Meals:");
        veganPlan.showMeals();

        System.out.println("\nHigh Protein Meals:");
        proteinPlan.showMeals();

        System.out.println("\nGenerating Personalized Meal:");
        Meal.generatePersonalizedMeal(new KetoMeal("Chicken Stir Fry"));
        Meal.generatePersonalizedMeal(new VegetarianMeal("Paneer Tikka"));
        Meal.generatePersonalizedMeal(new VeganMeal("Milk Soup"));
    }
}
