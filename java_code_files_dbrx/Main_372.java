import java.util.*;
public class Main_372{
    public static void main(String[] args){
        String input = "100111010001111100101010"; //Change this value with your string input
        HashMap<Character, Integer> charCountMap  = new HashMap<>();
        int currentCount = 1;
        for(int i=1; i < input.length(); i++){
            if (input.charAt(i) == input.charAt(i-1)){ //if the character at this position matches with previous one
                currentCount++;//increment count
            }else{
                charCountMap.put(Character.valueOf(input.charAt(i - 1)),currentCount); //add to map when we find different digit
                currentCount = 1; //reset count for new character
            }
        }
        // Add last sequence at the end of string.
        if (currentCount > 0) {
            charCountMap.put(Character.valueOf(input.charAt(input.length() - 1)), currentCount);
        }

        // Printing output
        for(Character character: charCountMap.keySet()){
            System.out.print(charCountMap.get(character)+":"+character+" ");
        }
    }
}