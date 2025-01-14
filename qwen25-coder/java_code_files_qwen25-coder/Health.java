public class Health {
    public static void processVitamin(int vitaminType) {
        // Implementation using old int enum style
        switch (vitaminType) {
            case VitaminType.RETINOL:
                System.out.println("Processing Retinol");
                break;
            case VitaminType.THIAMIN:
                System.out.println("Processing Thiamin");
                break;
            case VitaminType.RIBOFLAVIN:
                System.out.println("Processing Riboflavin");
                break;
            default:
                System.out.println("Unknown vitamin type");
                break;
        }
    }

    // Overloaded method using new enum style
    public static void processVitamin(VitaminType2 vitaminType) {
        switch (vitaminType) {
            case RETINOL:
                System.out.println("Processing Retinol");
                break;
            case THIAMIN:
                System.out.println("Processing Thiamin");
                break;
            case RIBOFLAVIN:
                System.out.println("Processing Riboflavin");
                break;
            default:
                System.out.println("Unknown vitamin type");
                break;
        }
    }

    public static void processNutrient(NutrientType nutrientType) {
        // implementation using new enum
    }

    public static void main(String[] args) {
        // Testing the methods
        processVitamin(VitaminType.RETINOL);
        processVitamin(VitaminType2.THIAMIN);
    }
}

class VitaminType {
    public static final int RETINOL = 1;
    public static final int THIAMIN = 2;
    public static final int RIBOFLAVIN = 3;
}

enum VitaminType2 {
    RETINOL, THIAMIN, RIBOFLAVIN;
}

enum NutrientType {
    PROTEIN, CARBOHYDRATE, FAT;
}