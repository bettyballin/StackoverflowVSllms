import java.lang.String;

public class TypedDataSetContainer {

    MyTypedDataSet anotherDataSet;
    MyTypedDataSet yetAnotherDataSet;
    MyTypedDataSet aDataSet = anotherDataSet;

    {
        aDataSet.Merge(yetAnotherDataSet);
    }

    public static void main(String[] args) {
    }
}