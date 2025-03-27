import java.util.*;

public class BinaryNumGenerationQueue {
    // Method to generate the first N binary numbers using a queue
    public static List<String> generateBinaryNumbers(int count) {
        List<String> resultList = new ArrayList<>();
        Queue<String> binaryQueue = new LinkedList<>();

        binaryQueue.offer("1"); // Start with "1"

        for (int i = 0; i < count; i++) {
            String currentBinary = binaryQueue.poll();
            resultList.add(currentBinary);

            // Generate next binary numbers and enqueue them
            binaryQueue.offer(currentBinary + "0");
            binaryQueue.offer(currentBinary + "1");
        }

        return resultList;
    }

    public static void main(String[] args) {
        int numberOfBinaries = 5;
        System.out.println("First " + numberOfBinaries + " Binary Numbers: " + generateBinaryNumbers(numberOfBinaries));
    }
}
