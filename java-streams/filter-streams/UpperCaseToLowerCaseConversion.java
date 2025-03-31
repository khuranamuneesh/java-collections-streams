import java.io.*;

public class UpperCaseToLowerCaseConversion {
    public static void main(String[] args) {
        String sourceFile = "sample.txt";
        String destinationFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                writer.write(line.toLowerCase());
                writer.newLine(); // Maintain line structure
            }

            System.out.println("Text in file successfully converted to lowercase!");
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
