import java.io.*;

public class IOExceptionExample {
    public static void main(String[] args) {
        String fileName = "data.txt";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }
    }
}

