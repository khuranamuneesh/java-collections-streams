import java.util.*;

interface MealPlan {
    String getMealType();
}

// Specific meal plans implementing MealPlan interface
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein Meal";
    }
}

// Generic class to handle meal plans
class Meal<T extends MealPlan> {
    private T mealType;
    private String user;

    public Meal(T mealType, String user) {
        this.mealType = mealType;
        this.user = user;
    }

    public T getMealType() {
        return mealType;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "User: " + user + " - Meal Plan: " + mealType.getMealType();
    }
}

// Utility class for meal plan operations
class MealUtility {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generating meal plan for: " + meal.getUser());
        System.out.println("Meal Type: " + meal.getMealType().getMealType());
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        // Creating meal plans for users
        Meal<VegetarianMeal> user1Meal = new Meal<>(new VegetarianMeal(), "Alice");
        Meal<VeganMeal> user2Meal = new Meal<>(new VeganMeal(), "Bob");
        Meal<KetoMeal> user3Meal = new Meal<>(new KetoMeal(), "Charlie");
        Meal<HighProteinMeal> user4Meal = new Meal<>(new HighProteinMeal(), "David");

        // Storing meal plans in a list
        List<Meal<?>> mealList = new ArrayList<>();
        mealList.add(user1Meal);
        mealList.add(user2Meal);
        mealList.add(user3Meal);
        mealList.add(user4Meal);

        // Displaying generated meal plans
        System.out.println("Personalized Meal Plans:");
        for (Meal<?> meal : mealList) {
            System.out.println(meal);
        }
    }
}
