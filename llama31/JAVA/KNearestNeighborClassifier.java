import java.lang.String;
import java.lang.Set;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;

public class KNearestNeighborClassifier {
  public static void main(String[] args) throws Exception {
    // Load the dataset
    DataSource source = new DataSource("your_data.arff");
    Instances data = source.getDataSet();
    data.setClassIndex(data.numAttributes() - 1); // Set the class index

    // Split the data into training and testing sets
    int trainSize = (int) Math.round(data.numInstances() * 0.8);
    Instances train = new Instances(data, 0, trainSize);
    Instances test = new Instances(data, trainSize, data.numInstances() - trainSize);

    // Create a k-nearest neighbor classifier with k=5
    IBk classifier = new IBk(5);

    // Train the classifier
    classifier.buildClassifier(train);

    // Evaluate the classifier on the test set
    Evaluation eval = new Evaluation(train);
    eval.evaluateModel(classifier, test);
    System.out.println(eval.toSummaryString());
  }
}