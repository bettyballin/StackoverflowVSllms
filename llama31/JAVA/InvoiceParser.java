import java.util.List;

// Parsing module
public class InvoiceParser {
  private TemplateEngine templateEngine;

  public InvoiceParser(TemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
  }

  public Invoice parse(String inputFile) {
    // Load the template for the input file
    Template template = templateEngine.getTemplate("invoice-template");

    // Parse the input file using the template
    Invoice invoice = new Invoice();
    // ... parse the file using the template ...

    return invoice;
  }
}

// Template engine
public interface TemplateEngine {
  Template getTemplate(String templateName);
}

// Template
public class Template {
  private List<Field> fields;

  public List<Field> getFields() {
    return fields;
  }
}

// Field
public class Field {
  private String name;
  private ValueType valueType;

  public String getName() {
    return name;
  }

  public ValueType getValueType() {
    return valueType;
  }
}

// ValueType
public enum ValueType {
  STRING,
  INTEGER,
  DATE
}

// Invoice
public class Invoice {
  private String customerName;
  private String customerId;
  // ... other fields ...

  public String getCustomerName() {
    return customerName;
  }

  public String getCustomerId() {
    return customerId;
  }

  public static void main(String[] args) {
    TemplateEngine templateEngine = new TemplateEngineImpl();
    InvoiceParser parser = new InvoiceParser(templateEngine);
    Invoice invoice = parser.parse("inputFile");
    System.out.println(invoice.getCustomerName());
  }
}

// TemplateEngine implementation
class TemplateEngineImpl implements TemplateEngine {
  public Template getTemplate(String templateName) {
    // Return a template implementation
    return new Template();
  }
}