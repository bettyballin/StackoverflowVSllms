import java.lang.String;
import java.lang.Integer;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class Main_91 {
    public static void main(String[] args) {
        int totalZipCodes = 80000;                     // Number of zip codes to store into the Bloom filter
        double falsePositiveRate = 0.1;                // Acceptable error rate (false positives) for your use case

        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), totalZipCodes, falsePositiveRate);

       // Add ZIP Codes to filter:
       int[] zips = {}; // Placeholder array for ZIP codes
       for (int zip : zips){
           bloomFilter.put(zip);
       }

       // Test for existence in the future:
       int newZipCodeToTest = 12345; // Sample ZIP code to test
       boolean maybeContains = bloomFilter.mightContain(newZipCodeToTest);
    }
}