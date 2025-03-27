import java.util.*;

public class ConvertSetToSortedList {
    // Method to convert a set to a sorted list
    public static List<Integer> convertAndSortSet(Set<Integer> numberSet) {
        List<Integer> sortedList = new ArrayList<>(numberSet);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        // Test conversion and sorting
        Set<Integer> unsortedSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        System.out.println("Original Set: " + unsortedSet);
        System.out.println("Sorted List: " + convertAndSortSet(unsortedSet));
    }
}

