import java.util.*;

public class TwoSetsEqualOrNot {
    // Method to check if two sets are equal
    public static <ItemType> boolean areSetsEqual(Set<ItemType> firstSet, Set<ItemType> secondSet) {
        return firstSet.equals(secondSet);
    }

    public static void main(String[] args) {
        // Test check for set equality
        Set<Integer> numberSet1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> numberSet2 = new HashSet<>(Arrays.asList(3, 2, 1));

        System.out.println("Set 1: " + numberSet1);
        System.out.println("Set 2: " + numberSet2);
        System.out.println("Are both sets equal? " + areSetsEqual(numberSet1, numberSet2));
    }
}
