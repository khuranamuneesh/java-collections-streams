import java.util.*;

public class FrequencyOfElements {
    // Method to find frequency of elements in a list
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        // Test frequency count
        List<String> stringList = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println("Input List: " + stringList);
        System.out.println("Frequency of elements: " + findFrequency(stringList));
    }
}

