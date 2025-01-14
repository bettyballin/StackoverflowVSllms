import java.lang.String;

public class DataSetMerger {

    MyTypedDataSet aDataSet = new MyTypedDataSet();
    MyTypedDataSet anotherDataSet;
    MyTypedDataSet yetAnotherDataSet;

    {
        aDataSet.Merge(anotherDataSet);
        aDataSet.Merge(yetAnotherDataSet);
    }

    public static void main(String[] args) {
    }
}

class MyTypedDataSet {
    public void Merge(MyTypedDataSet dataSet) {
        // Implementation here
    }
}