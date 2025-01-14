public class Car_1 {
    // Object-oriented approach
    class Car {
        private String make;
        private String model;

        public Car(String make, String model) {
            this.make = make;
            this.model = model;
        }

        public void drive() {
            System.out.println("Driving " + make + " " + model);
        }
    }

    // REST-like resource representation (simplified)
    class CarResource {
        private Car car;

        public CarResource(String make, String model) {
            this.car = new Car(make, model);
        }

        public void handleGetRequest() {
            // Simulate a GET request response
            System.out.println("Car details - Make: " + car.make + ", Model: " + car.model);
        }

        public void handlePostRequest(String action) {
            // Simulate an action on the resource
            if ("drive".equals(action)) {
                car.drive();
            }
        }
    }

    public static void main(String[] args) {
    }
}