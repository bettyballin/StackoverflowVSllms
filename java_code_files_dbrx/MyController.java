// Actions from user interfaces or network layer might invoke these request handlers
public class MyController {
   public void createCustomerOrder(int customerId){
      var order = new Order(); // Create an empty order
      Customer customer = Customers.getById(customerId); // Get the related client
      if (validationOk(order, customer)) { // Is it valid to proceed?
         Orders.add(order);  // Save a record in model's storage
      }
      else {
         // validation failure: show an error message or do other tasks
         System.out.println("Validation failed");
      } 
   }

   private boolean validationOk(Order order, Customer customer) {
      // Assume validation logic here; for now, return true
      return true;
   }
}

class Order {
    // Empty class for Order
}

class Customer {
    // Empty class for Customer
}

class Customers {
    public static Customer getById(int customerId) {
        return new Customer();
    }
}

class Orders {
    public static void add(Order order) {
        // Implementation to add order
    }
}