import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Custom comparator for prioritizing patients with higher severity
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(
                (p1, p2) -> Integer.compare(p2.severity, p1.severity) // Higher severity first
        );

        // Adding patients
        triageQueue.offer(new Patient("John", 3));
        triageQueue.offer(new Patient("Alice", 5));
        triageQueue.offer(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}
