import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee Details - \n[ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

public class SavingAndRetrievingAnObject {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Akash", "HR", 52000));
        employees.add(new Employee(2, "Rohan", "IT", 74500));
        employees.add(new Employee(3, "Sam", "Finance", 67000));

        serializeEmployees(employees);
        List<Employee> deserializedEmployees = deserializeEmployees();

        System.out.println("Deserialized Employee List:");
        for (Employee emp : deserializedEmployees) {
            System.out.println(emp);
        }
    }

    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static List<Employee> deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
