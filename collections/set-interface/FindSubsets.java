import java.util.*;

public class FindSubsets {
    // Method to check if one set is a subset of another
    public static <ItemType> boolean isSubset(Set<ItemType> smallSet, Set<ItemType> largeSet) {
        return largeSet.containsAll(smallSet);
    }

    public static void main(String[] args) {
        // Test subset check
        Set<Integer> subsetCheck1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> subsetCheck2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Set 1: " + subsetCheck1);
        System.out.println("Set 2: " + subsetCheck2);
        System.out.println("Is Set 1 a subset of Set 2? " + isSubset(subsetCheck1, subsetCheck2));
    }
}
