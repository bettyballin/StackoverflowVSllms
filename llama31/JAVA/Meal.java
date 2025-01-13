import java.util.ArrayList;
import java.util.List;

class Meal {
    private Long id;
    private String name;
    private String description;
    private List<MealComponent> components;

    public Meal(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.components = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MealComponent> getComponents() {
        return components;
    }

    public void setComponents(List<MealComponent> components) {
        this.components = components;
    }
}

class Component {
    private Long id;
    private String name;
    private String type;

    public Component(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class MealComponent {
    private Long mealId;
    private Long componentId;
    private String role;
    private Integer quantity;

    public MealComponent(Long mealId, Long componentId, String role, Integer quantity) {
        this.mealId = mealId;
        this.componentId = componentId;
        this.role = role;
        this.quantity = quantity;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Meal meal = new Meal(1L, "Cheeseburger", "A tasty burger");
        Component fries = new Component(1L, "Fries", "Fries");
        Component beverage = new Component(2L, "Soda", "Beverage");

        MealComponent mealComponent1 = new MealComponent(meal.getId(), fries.getId(), "Required", 1);
        MealComponent mealComponent2 = new MealComponent(meal.getId(), beverage.getId(), "Optional", null);

        meal.getComponents().add(mealComponent1);
        meal.getComponents().add(mealComponent2);
    }
}