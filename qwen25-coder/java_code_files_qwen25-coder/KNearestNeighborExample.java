import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk; // IBk is Weka's k-NN implementation
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class KNearestNeighborExample {
    public static void main(String[] args) throws Exception {
        Instances train = new DataSource("path/to/train.arff").getDataSet();
        Instances test = new DataSource("path/to/test.arff").getDataSet();

        // Set the class index
        int numAttributes = train.numAttributes();
        train.setClassIndex(numAttributes - 1);
        test.setClassIndex(numAttributes - 1);

        IBk knn = new IBk(3); // k = 3 (you can set any k)
        knn.buildClassifier(train);

        for (int i = 0; i < test.numInstances(); i++) {
            double pred = knn.classifyInstance(test.instance(i));
            System.out.println("Predicted: " + pred + ", Actual: " + test.instance(i).classValue());
        }
    }
}