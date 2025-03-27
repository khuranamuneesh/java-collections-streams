import java.util.*;

public class RemoveDuplicatedSameOrder {
    // Method to remove duplicates while preserving order
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> elementsWatched = new HashSet<>();
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (elementsWatched.add(item)) { // Added to the set if it's not watched before
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test remove duplicates
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("Original List: " + list);
        System.out.println("List after removing duplicates: " + removeDuplicates(list));
    }
}

