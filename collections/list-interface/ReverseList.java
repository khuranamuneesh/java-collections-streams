import java.util.*;

public class ReverseList {
    // Method to reverse an ArrayList
    public static <T> void reverseArrayList(ArrayList<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left); //swapping elements
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    // Method to reverse a LinkedList
    public static <T> void reverseLinkedList(LinkedList<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left); //swapping elements
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Test with ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("The Original ArrayList: " + arrayList);
        reverseArrayList(arrayList);
        System.out.println("The Reversed ArrayList: " + arrayList);

        // Test with LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("The Original LinkedList: " + linkedList);
        reverseLinkedList(linkedList);
        System.out.println("The reversed LinkedList: " + linkedList);
    }
}

