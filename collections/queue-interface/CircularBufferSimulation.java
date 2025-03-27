
public class CircularBufferSimulation {
    private int[] buffer;
    private int capacity;
    private int front;
    private int rear;
    private int size;

    public CircularBufferSimulation(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Insert an element into the buffer
    public void insert(int value) {
        rear = (rear + 1) % capacity;
        buffer[rear] = value;
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity; // Overwrite the oldest element
        }
    }

    // Display the buffer content
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBufferSimulation cb = new CircularBufferSimulation(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); // Output: [1, 2, 3]

        cb.insert(4); // Overwrites 1
        cb.display(); // Output: [2, 3, 4]

        cb.insert(5); // Overwrites 2
        cb.display(); // Output: [3, 4, 5]
    }
}
