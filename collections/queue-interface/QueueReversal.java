import java.util.*;

public class QueueReversal {
    // Method to reverse a queue using only queue operations
    public static <ItemType> Queue<ItemType> reverse(Queue<ItemType> inputQueue) {
        Stack<ItemType> helperStack = new Stack<>();

        // Dequeue all elements and push them onto the stack
        while (!inputQueue.isEmpty()) {
            helperStack.push(inputQueue.poll());
        }

        // Pop from stack and enqueue back into queue
        while (!helperStack.isEmpty()) {
            inputQueue.offer(helperStack.pop());
        }

        return inputQueue;
    }

    public static void main(String[] args)
    {
        Queue<Integer> numberQueue = new LinkedList<>(Arrays.asList(10, 20, 30));// Test queue reversal
        System.out.println("Original Queue: " + numberQueue);
        System.out.println("Reversed Queue: " + reverse(numberQueue));
    }
}
