import java.util.*;

public class MyClass {

    private static final String SUCCESS = "SUCCESS";

    public String getFieldHtml(){
        FieldsTO fields = new FieldsTO(); // Populate fields with actual field properties as needed
        StringBuilder resultHTMLString = new StringBuilder();
        String linePrefix = "<div>";
        String lineEnd = "</div>"; // Or use a more descriptive wrapper, e.g., <fieldset>
        for(FieldTO ft : fields.getFields()){
            resultHTMLString.append("<s:textfield name='" + ft.getName() + "'/>").append(" ");
        }
        String fieldLine = linePrefix + resultHTMLString.toString().replaceAll(",$", "") + lineEnd; // Remove excess commas
        return SUCCESS;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        String html = myClass.getFieldHtml();
        System.out.println(html);
    }

    private static class FieldsTO {

        private List<FieldTO> fields;

        public FieldsTO() {
            // Populate fields with actual field properties as needed
            fields = new ArrayList<>();
            fields.add(new FieldTO("field1"));
            fields.add(new FieldTO("field2"));
            fields.add(new FieldTO("field3"));
        }

        public List<FieldTO> getFields() {
            return fields;
        }
    }

    private static class FieldTO {

        private String name;

        public FieldTO(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}