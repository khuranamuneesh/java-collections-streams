import java.io.*;
import java.util.*;

public class CountWordsInFile {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Replace with actual file path
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null)
            {
                StringBuilder word = new StringBuilder();
                for (int i = 0; i < line.length(); i++)
                {
                    char c = line.charAt(i);
                    // Check if the character is a letter or digit
                    if (Character.isLetterOrDigit(c) || c == '\'')
                    {
                        word.append(c);
                    }
                    else
                    {
                        if (word.length() > 0)
                        {
                            String cleanedWord = word.toString().toLowerCase();
                            wordCountMap.put(cleanedWord, wordCountMap.getOrDefault(cleanedWord, 0) + 1);
                            word.setLength(0); // Clear the current word
                        }
                    }
                }
                // Handle the last word in the line (if any)
                if (!word.isEmpty()) {
                    String cleanedWord = word.toString().toLowerCase();
                    wordCountMap.put(cleanedWord, wordCountMap.getOrDefault(cleanedWord, 0) + 1);
                }
            }

            // Sort the map by frequency
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
            sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            System.out.println("The top 5 most frequent words occurring in file are:");
            for (int i = 0; i < 5 && i < sortedList.size(); i++)
            {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
        catch (IOException e)
        {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }
}
