import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.bayes.NaiveBayes;

public class ImageRestrictionClassifier {
    public static void main(String[] args) throws Exception {
        // Load the dataset
        DataSource source = new DataSource("metadata.arff");
        Instances data = source.getDataSet();

        // Set class index to the last attribute (assuming labels are in the last column)
        if (data.classIndex() == -1)
            data.setClassIndex(data.numAttributes() - 1);

        // Train the Naive Bayes classifier
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(data);

        System.out.println("Naive Bayes model built successfully with given dataset.");
    }
}