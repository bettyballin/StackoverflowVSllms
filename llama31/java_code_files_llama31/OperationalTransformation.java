/*
 * Decompiled with CFR 0.152.
 */
public class OperationalTransformation {
    private String document;

    public OperationalTransformation(String string) {
        this.document = string;
    }

    public void applyOperation(Operation operation) {
        this.document = operation.apply(this.document);
    }

    public Operation transform(Operation operation, Operation operation2) {
        return operation.transform(operation2);
    }

    public static void main(String[] stringArray) {
        OperationalTransformation operationalTransformation = new OperationalTransformation("Hello World");
        Operation operation = new Operation("insert", 6, " Beautiful");
        Operation operation2 = new Operation("delete", 0, "H");
        operationalTransformation.applyOperation(operation);
        System.out.println(operationalTransformation.document);
        operationalTransformation.applyOperation(operation2);
        System.out.println(operationalTransformation.document);
        Operation operation3 = operationalTransformation.transform(operation, operation2);
        System.out.println(operation3.type + " " + operation3.position + " " + operation3.text);
    }

    public static class Operation {
        private String type;
        private int position;
        private String text;

        public Operation(String string, int n, String string2) {
            this.type = string;
            this.position = n;
            this.text = string2;
        }

        public String apply(String string) {
            if (this.type.equals("insert")) {
                return string.substring(0, this.position) + this.text + string.substring(this.position);
            }
            if (this.type.equals("delete")) {
                return string.substring(0, this.position) + string.substring(this.position + this.text.length());
            }
            return string;
        }

        public Operation transform(Operation operation) {
            if (this.type.equals("insert") && operation.type.equals("insert")) {
                if (this.position <= operation.position) {
                    return new Operation("insert", this.position, this.text);
                }
                return new Operation("insert", this.position + operation.text.length(), this.text);
            }
            if (this.type.equals("insert") && operation.type.equals("delete")) {
                if (this.position <= operation.position) {
                    return new Operation("insert", this.position, this.text);
                }
                return new Operation("insert", this.position - operation.text.length(), this.text);
            }
            if (this.type.equals("delete") && operation.type.equals("insert")) {
                if (this.position <= operation.position) {
                    return new Operation("delete", this.position, this.text);
                }
                return new Operation("delete", this.position + operation.text.length(), this.text);
            }
            if (this.type.equals("delete") && operation.type.equals("delete")) {
                if (this.position <= operation.position) {
                    return new Operation("delete", this.position, this.text);
                }
                return new Operation("delete", this.position - operation.text.length(), this.text);
            }
            return this;
        }
    }
}
