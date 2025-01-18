import java.util.*;
public class Main_331 {
    public static void main(String[] args) {
        String[] words = new String[]{"the", "dog", "jumped", "over", "the", "wall.", "the", "cat","felI","off","the", "house."}; //words array filled with sentences
        Map<String, ArrayList<String>> wordMap = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < words.length - 1; ++i) { // iterating through the length of array -1 as we are getting value from words[i+1] position
            String aKey = words[i];
            ArrayList<String> values = wordMap.getOrDefault(aKey, new ArrayList<String>()); // retrieving values for each key
            values.add(words[i + 1]); // adding the next following value to list
            wordMap.put(aKey, values); // placing key and its list into map
        }
    }
}