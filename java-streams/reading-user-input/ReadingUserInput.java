import java.io.*;

public class ReadingUserInput {
    public static void main(String[] args) {
        String fileName = "user_data.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true))
        { // Append mode
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            writer.write("\n");

            System.out.println("User data saved successfully! in the file. ");
        }
        catch (IOException e)
        {
            System.out.println("Error: An I/O error occurred due to - " + e.getMessage());
        }
    }
}
