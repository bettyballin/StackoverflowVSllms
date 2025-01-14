import java.lang.String;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;

public class MinDistanceClassifier {
    public static void main(String[] args) throws Exception {
        // Load dataset
        DataSource source = new DataSource("path/to/dataset.arff");
        Instances data = source.getDataSet();
        
        // Normalize the dataset
        Normalize normFilter = new Normalize();
        normFilter.setInputFormat(data);
        Instances normalizedData = Filter.useFilter(data, normFilter);

        // Implement Minimum Distance Classifier manually here
    }
}