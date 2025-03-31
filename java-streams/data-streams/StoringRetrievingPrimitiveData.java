import java.io.*;

public class StoringRetrievingPrimitiveData {
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        // Writing student details to file
        writeStudentData(101, "Aryan", 8.5);
        writeStudentData(212, "Mehak", 7.9);
        writeStudentData(187, "Raj", 6.8);
        writeStudentData(116, "Karan", 7.8);
        writeStudentData(302, "Anita", 9.1);
        writeStudentData(250, "Sanjay", 4.9);

        // Reading student details from file
        readStudentData();
    }

    private static void writeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data saved: " + rollNumber + ", " + name + ", " + gpa);
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    private static void readStudentData() {
        try (DataInputStream fileInput = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nReading student data:");
            while (fileInput.available() > 0) {
                int rollNumber = fileInput.readInt();
                String name = fileInput.readUTF();
                double gpa = fileInput.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
