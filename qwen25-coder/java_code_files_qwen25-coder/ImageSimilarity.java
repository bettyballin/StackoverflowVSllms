import java.util.*;

public class ImageSimilarity {
    public static double computeCosineSimilarity(Map<String, Double> vectorA, Map<String, Double> vectorB) {
        Set<String> intersection = new HashSet<>(vectorA.keySet());
        intersection.retainAll(vectorB.keySet());

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (String key : intersection) {
            dotProduct += vectorA.get(key) * vectorB.get(key);
        }

        for (String key : vectorA.keySet()) {
            normA += Math.pow(vectorA.get(key), 2);
        }
        for (String key : vectorB.keySet()) {
            normB += Math.pow(vectorB.get(key), 2);
        }

        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    public static void main(String[] args) {
        // Assuming keywordVectors map image IDs to their TF-IDF vectors
        Map<String, Map<String, Double>> keywordVectors = new HashMap<>();
        
        // Example usage: compute similarity between two images
        String imageId1 = "image1";
        String imageId2 = "image2";
        
        double similarity = computeCosineSimilarity(keywordVectors.get(imageId1), keywordVectors.get(imageId2));
        System.out.println("Cosine similarity between " + imageId1 + " and " + imageId2 + ": " + similarity);
    }
}