import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "form")
@XmlAccessorType(XmlAccessType.FIELD)
public class Form {
    @XmlAttribute
    private String name;
    
    @XmlElementWrapper(name = "fields")
    @XmlElement(name = "field")
    private List<Field> fields;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Field {
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String label;
    @XmlAttribute
    private boolean required;

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    } 

    public String getLabel() {
        return label;
    } 

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isRequired() {
        return required;
    } 

    public void setRequired(boolean required) {
        this.required = required;
    }

    public static void main(String[] args) {
    }
}