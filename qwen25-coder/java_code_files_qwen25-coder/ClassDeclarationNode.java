import java.util.List;

public class ClassDeclarationNode {
    IdentifierNode className;
    InheritanceNode extendsClass; // Optional
    PropertyListNode properties;
    MethodListNode methods;

    public ClassDeclarationNode(IdentifierNode class_name, 
                                InheritanceNode extends_class, 
                                PropertyListNode props, 
                                MethodListNode meths) {
        this.className = class_name;
        this.extendsClass = extends_class;
        this.properties = props;
        this.methods = meths;
    }

    // Inner classes
    public static class IdentifierNode {
        String identifier;

        public IdentifierNode(String ident) {
            this.identifier = ident;
        }
    }

    public static class InheritanceNode {
        IdentifierNode parentClassName;

        public InheritanceNode(IdentifierNode parentClass) {
            this.parentClassName = parentClass;
        }
    }

    public static class PropertyListNode {
        List<PropertyDeclarationNode> properties;

        public PropertyListNode(List<PropertyDeclarationNode> props) {
            this.properties = props;
        }

        public void addProperty(PropertyDeclarationNode prop) {
            properties.add(prop);
        }
    }

    public static class MethodListNode {
        List<MethodDeclarationNode> methods;

        public MethodListNode(List<MethodDeclarationNode> meths) {
            this.methods = meths;
        }

        public void addMethod(MethodDeclarationNode method) {
            methods.add(method);
        }
    }

    public static class PropertyDeclarationNode {
        IdentifierNode propertyName;
        ExpressionNode initialValue; // Optional

        public PropertyDeclarationNode(IdentifierNode propertyName, ExpressionNode initialValue) {
            this.propertyName = propertyName;
            this.initialValue = initialValue;
        }
    }

    public static class MethodDeclarationNode {
        IdentifierNode methodName;
        ParameterListNode parameters;
        StatementListNode body;

        public MethodDeclarationNode(IdentifierNode methodName, ParameterListNode parameters, StatementListNode body) {
            this.methodName = methodName;
            this.parameters = parameters;
            this.body = body;
        }
    }

    public static class ExpressionNode {
        // Empty class for compilation
    }

    public static class ParameterListNode {
        // Empty class for compilation
    }

    public static class StatementListNode {
        // Empty class for compilation
    }

    public static void main(String[] args) {
    }
}