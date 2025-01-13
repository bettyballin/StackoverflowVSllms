/*
 * Decompiled with CFR 0.152.
 */
class RecalculationVisitor
implements ExpressionVisitor {
    RecalculationVisitor() {
    }

    @Override
    public Object visit(Node node) {
        switch (node.type) {
            case OPERAND: {
                return node.value;
            }
            case BINARY_OPERATOR: {
                Object object = this.visit(node.left);
                Object object2 = this.visit(node.right);
                return (Double)object + (Double)object2;
            }
            case UNARY_OPERATOR: {
                Object object = this.visit(node.left);
                return -((Double)object).doubleValue();
            }
            case FUNCTION: {
                return null;
            }
        }
        return null;
    }
}
