import java.util.*;

public class SetSymmetricDifference {
    // Method to compute the symmetric difference of two sets
    public static <ItemType> Set<ItemType> computeSymmetricDifference(Set<ItemType> firstSet, Set<ItemType> secondSet) {
        Set<ItemType> differenceSet = new HashSet<>(firstSet);
        Set<ItemType> tempSet = new HashSet<>(secondSet);

        differenceSet.removeAll(secondSet);
        tempSet.removeAll(firstSet);

        differenceSet.addAll(tempSet);
        return differenceSet;
    }

    public static void main(String[] args) {
        // Test symmetric difference
        Set<Integer> numberSet1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> numberSet2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Set 1: " + numberSet1);
        System.out.println("Set 2: " + numberSet2);
        System.out.println("Symmetric Difference: " + computeSymmetricDifference(numberSet1, numberSet2));
    }
}
