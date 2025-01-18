public class DataSetProperties {
    static MyDataSet myDataSet = new MyDataSet();

    static {
        myDataSet.Readonly = true;
    }

    public static void main(String[] args) {
    }
}

class MyDataSet {
    public boolean Readonly;
}