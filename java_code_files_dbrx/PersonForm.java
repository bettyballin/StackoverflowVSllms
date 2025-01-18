// PersonForm.java

import org.apache.struts.action.ActionForm;

// Original action form class in Struts 1
public class PersonForm extends ActionForm {
    private String name;
    // Getter and Setter for 'name'

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}