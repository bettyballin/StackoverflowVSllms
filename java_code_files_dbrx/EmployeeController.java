import java.lang.String;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

public class EmployeeController {
    @PutMapping("{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        // code that modifies resource with provided entity
        return ResponseEntity.noContent().build(); // 204 No Content with no body in response
    }
    public static void main(String[] args) {
    }
}

class Employee {
    // Employee fields and methods
}