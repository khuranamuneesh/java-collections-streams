import java.util.*;

public class NthElementPositionFromEnd {
    // Method to find the Nth element from the end
    public static <ItemType> ItemType findNthFromEnd(LinkedList<ItemType> itemList, int positionFromEnd) {
        Iterator<ItemType> leadingPointer = itemList.iterator();
        Iterator<ItemType> trailingPointer = itemList.iterator();

        // Move leading pointer positionFromEnd steps ahead
        for (int step = 0; step < positionFromEnd; step++) {
            if (!leadingPointer.hasNext()) {
                throw new IllegalArgumentException("Position exceeds the list size");
            }
            leadingPointer.next();
        }

        // Move both pointers until leadingPointer reaches the end
        while (leadingPointer.hasNext()) {
            leadingPointer.next();
            trailingPointer.next();
        }

        return trailingPointer.next();
    }

    public static void main(String[] args) {
        // Test findNthFromEnd
        LinkedList<String> namesList = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int position = 2;
        System.out.println("Original List: " + namesList);
        System.out.println("Nth element from end: " + findNthFromEnd(namesList, position));
    }
}
