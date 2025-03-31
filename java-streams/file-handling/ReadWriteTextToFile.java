import java.io.*;

public class ReadWriteTextToFile {
    public static void main(String[] args) {
        String sourceFile = "sample.txt";
        String destinationFile = "muneesh.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile))
        {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully!");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: Source file not found on given path.");
        }
        catch (IOException e)
        {
            System.out.println("Error: An I/O error of Java streams occurred.");
        }
    }
}
