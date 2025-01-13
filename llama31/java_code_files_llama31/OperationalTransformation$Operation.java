/*
 * Decompiled with CFR 0.152.
 */
public static class OperationalTransformation.Operation {
    private String type;
    private int position;
    private String text;

    public OperationalTransformation.Operation(String string, int n, String string2) {
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

    public OperationalTransformation.Operation transform(OperationalTransformation.Operation operation) {
        if (this.type.equals("insert") && operation.type.equals("insert")) {
            if (this.position <= operation.position) {
                return new OperationalTransformation.Operation("insert", this.position, this.text);
            }
            return new OperationalTransformation.Operation("insert", this.position + operation.text.length(), this.text);
        }
        if (this.type.equals("insert") && operation.type.equals("delete")) {
            if (this.position <= operation.position) {
                return new OperationalTransformation.Operation("insert", this.position, this.text);
            }
            return new OperationalTransformation.Operation("insert", this.position - operation.text.length(), this.text);
        }
        if (this.type.equals("delete") && operation.type.equals("insert")) {
            if (this.position <= operation.position) {
                return new OperationalTransformation.Operation("delete", this.position, this.text);
            }
            return new OperationalTransformation.Operation("delete", this.position + operation.text.length(), this.text);
        }
        if (this.type.equals("delete") && operation.type.equals("delete")) {
            if (this.position <= operation.position) {
                return new OperationalTransformation.Operation("delete", this.position, this.text);
            }
            return new OperationalTransformation.Operation("delete", this.position - operation.text.length(), this.text);
        }
        return this;
    }
}
