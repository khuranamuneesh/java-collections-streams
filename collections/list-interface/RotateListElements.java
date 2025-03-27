import java.util.*;

public class RotateListElements
{
    public static <T> void rotateList(List<T> list, int positions)
    {
        int size = list.size(); // Method to rotate elements in a list
        positions = positions % size;
        List<T> rotatedPart = new ArrayList<>(list.subList(positions, size));
        rotatedPart.addAll(list.subList(0, positions));
        list.clear();
        list.addAll(rotatedPart);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List: " + list);
        rotateList(list, 2);
        System.out.println("Rotated List: " + list);
    }
}

