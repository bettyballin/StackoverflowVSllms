// File: SingularConverter.java
import net.mflection.Pluralizer;

public class SingularConverter {
    public static void main(String[] args) {
        Pluralizer pluralizer = new Pluralizer();

        String[] words = {"Types", "Categories", "Series", "News"};

        for (String word : words) {
            System.out.println("Plural: " + word + ", Singular: " + pluralizer.singular(word));
        }
    }
}

// File: net/mflection/Pluralizer.java
package net.mflection;

public class Pluralizer {

    public String singular(String word) {
        if (word.endsWith("ies")) {
            // Remove 'ies' and add 'y'
            return word.substring(0, word.length() - 3) + "y";
        } else if (word.endsWith("s") && !word.endsWith("ss")) {
            // Remove trailing 's'
            return word.substring(0, word.length() - 1);
        } else {
            // Return the word itself if it's already singular or uncountable
            return word;
        }
    }
}