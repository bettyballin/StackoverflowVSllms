import java.lang.String;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers")
public class CustomerResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        // Use a DAO to insert the customer data into the database
        CustomerDAO dao = new CustomerDAO();
        dao.createCustomer(customer);
        return Response.status(201).entity("Customer created").build();
    }

    public static void main(String[] args) {
    }
}

class Customer {
    // Define the Customer class properties and methods here
}

class CustomerDAO {
    // Define the CustomerDAO class properties and methods here
    public void createCustomer(Customer customer) {
        // Implement the logic to insert the customer data into the database
    }
}