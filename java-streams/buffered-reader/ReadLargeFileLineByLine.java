import java.io.*;

public class ReadLargeFileLineByLine
{
    public static void main(String[] args)
    {
        String filePath = "largeFile.txt";

        try (BufferedReader readerFile = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = readerFile.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
