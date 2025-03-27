import java.util.*;
import java.io.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        Map<String, Integer> wordCount = new HashMap<>();

        // Convert to lowercase and remove punctuation manually
        text = text.toLowerCase().replace(".", "").replace(",", "").replace("!", "");

        // Split by spaces
        String[] words = text.split(" ");

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println(wordCount);
    }
}
