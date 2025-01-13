/*
 * Decompiled with CFR 0.152.
 */
public class Main_559 {
    public static Node parseFormula(String string) {
        Node node = new Node(NodeType.OPERAND, (Object)2.0, null, null);
        Node node2 = new Node(NodeType.OPERAND, (Object)3.0, null, null);
        Node node3 = new Node(NodeType.OPERAND, (Object)4.0, null, null);
        Node node4 = new Node(NodeType.BINARY_OPERATOR, (Object)"*", node2, node3);
        Node node5 = new Node(NodeType.BINARY_OPERATOR, (Object)"+", node, node4);
        return node5;
    }

    public static void main(String[] stringArray) {
        String string = "2+3*4";
        Node node = Main_559.parseFormula(string);
        RecalculationVisitor recalculationVisitor = new RecalculationVisitor();
        Object object = recalculationVisitor.visit(node);
        System.out.println("Result: " + String.valueOf(object));
    }
}
