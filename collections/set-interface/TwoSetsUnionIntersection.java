import java.util.*;

public class TwoSetsUnionIntersection {
    // Method to compute the union of two sets
    public static <ItemType> Set<ItemType> computeUnion(Set<ItemType> firstSet, Set<ItemType> secondSet) {
        Set<ItemType> unionSet = new HashSet<>(firstSet);
        unionSet.addAll(secondSet);
        return unionSet;
    }

    // Method to compute the intersection of two sets
    public static <ItemType> Set<ItemType> computeIntersection(Set<ItemType> firstSet, Set<ItemType> secondSet) {
        Set<ItemType> intersectionSet = new HashSet<>(firstSet);
        intersectionSet.retainAll(secondSet);
        return intersectionSet;
    }

    public static void main(String[] args) {

        Set<Integer> numberSet1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> numberSet2 = new HashSet<>(Arrays.asList(3, 4, 5));
        // Test union and intersection
        System.out.println("Set 1: " + numberSet1);
        System.out.println("Set 2: " + numberSet2);
        System.out.println("Union: " + computeUnion(numberSet1, numberSet2));
        System.out.println("Intersection: " + computeIntersection(numberSet1, numberSet2));
    }
}
