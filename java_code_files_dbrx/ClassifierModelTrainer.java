import java.io.BufferedReader;
import java.io.FileReader;

import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class ClassifierModelTrainer {

    Classifier cls;

    public ClassifierModelTrainer() throws Exception {
        // Initialize the classifier
        cls = new NaiveBayes(); // Any Classification algorithm can be used instead of Naive Bayes here.

        // Read the training data
        BufferedReader reader = new BufferedReader(new FileReader("training_data.arff")); // Path to your training_file in Weka format ARFF or CSV
        Instances trainData = new Instances(reader);
        trainData.setClassIndex(trainData.numAttributes() - 1); // Setting the last column as Class attribute

        // Build the classifier
        try {
            cls.buildClassifier(trainData);
        } catch (Exception e) {
            throw new Exception("Classification failed", e);
        }

        reader.close();
    }

    public static void main(String[] args) {
        try {
            new ClassifierModelTrainer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}