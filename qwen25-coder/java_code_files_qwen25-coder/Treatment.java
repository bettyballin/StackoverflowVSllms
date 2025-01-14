import java.util.HashMap;
import java.util.Map;

class Treatment {
    private String id;
    private String description;
    private int duration; // in minutes
    private double price;

    public Treatment(String id, String description, int duration, double price) {
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.price = price;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDescription(){
        return description;
    }

    public int getDuration(){
        return duration;
    }

    public double getPrice() {
        return price;
    }

    // Setters can be added if needed
}

class BeautyShop {
    private Map<String, Treatment> treatments; // key = treatment ID

    public BeautyShop() {
        treatments = new HashMap<>();
    }

    public void addTreatment(Treatment treatment) {
        treatments.put(treatment.getId(), treatment);
    }

    public Treatment getTreatment(String id) {
        return treatments.get(id);
    }
}

class Employee {
    private BeautyShop beautyShop;
    private Map<String, Treatment> specializedTreatments; // key = treatment ID

    public Employee(BeautyShop beautyShop) {
        this.beautyShop = beautyShop;
        specializedTreatments = new HashMap<>();
    }

    public void specializeTreatment(Treatment treatmentOverride) {
        specializedTreatments.put(treatmentOverride.getId(), treatmentOverride);
    }

    public Treatment getTreatment(String id) {
        if (specializedTreatments.containsKey(id)) {
            return specializedTreatments.get(id);
        }
        return beautyShop.getTreatment(id);
    }
}

public class Main {
    public static void main(String[] args) {
        BeautyShop shop = new BeautyShop();
        Treatment treatmentA = new Treatment("a1", "Facial", 60, 100.0);
        shop.addTreatment(treatmentA);

        Employee emp = new Employee(shop);
        Treatment specializedTreatmentA = new Treatment("a1", "Advanced Facial", 90, 200.0);
        emp.specializeTreatment(specializedTreatmentA);

        System.out.println(emp.getTreatment("a1").getDescription() + " - " + emp.getTreatment("a1").getPrice());
    }
}