import net.sf.saxon.expr.Expression;
import net.sf.saxon.expr.XPathContext;
import net.sf.saxon.lib.ExtensionFunctionCall;
import net.sf.saxon.om.AxisInfo;
import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.om.Sequence;
import net.sf.saxon.pattern.NameTest;
import net.sf.saxon.trans.XPathException;
import net.sf.saxon.type.Type;
import net.sf.saxon.value.SequenceType;
import net.sf.saxon.value.StringValue;

public class OurFunctionCall extends ExtensionFunctionCall {

    @Override
    public SequenceType[] getArgumentTypes() {
        return new SequenceType[]{};
    }

    @Override
    public SequenceType getResultType(SequenceType[] suppliedArgumentTypes) {
        return SequenceType.SINGLE_STRING;
    }

    @Override
    public Expression makeCallExpression() throws XPathException {
        return this;
    }

    @Override
    public Sequence call(XPathContext context, Sequence[] arguments) throws XPathException {
        NodeInfo currentNode = (NodeInfo) context.getContextItem();

        // Example: Retrieve the value of <bar>
        NameTest test = new NameTest(Type.ELEMENT, "", "bar", null);
        NodeInfo barNode = (NodeInfo) currentNode.iterateAxis(AxisInfo.CHILD, test).next();
        String barValue = barNode == null ? "" : barNode.getStringValue();

        return new StringValue(barValue);
    }

    public static void main(String[] args) {
    }
}