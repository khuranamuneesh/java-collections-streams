import java.util.*;

public class ImplementStackUsingQueues {
    private Queue<Integer> mainQueue = new LinkedList<>();
    private Queue<Integer> helperQueue = new LinkedList<>();

    // Push operation
    public void push(int value) {
        mainQueue.offer(value);
    }

    // Pop operation
    public int pop() {
        if (mainQueue.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move elements except the last one to helperQueue
        while (mainQueue.size() > 1) {
            helperQueue.offer(mainQueue.poll());
        }

        // Last element in mainQueue is the top element
        int poppedValue = mainQueue.poll();

        // Swap queues
        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;

        return poppedValue;
    }

    // Top operation
    public int top() {
        if (mainQueue.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move elements except the last one to helperQueue
        while (mainQueue.size() > 1) {
            helperQueue.offer(mainQueue.poll());
        }

        // Get the last element
        int topValue = mainQueue.poll();
        helperQueue.offer(topValue);

        // Swap queues
        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;

        return topValue;
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top Element: " + stack.top()); // Output: 3
        System.out.println("Popped Element: " + stack.pop()); // Output: 3
        System.out.println("Top Element after Pop: " + stack.top()); // Output: 2
    }
}
