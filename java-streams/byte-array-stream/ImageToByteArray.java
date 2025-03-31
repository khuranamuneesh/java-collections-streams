import java.io.*;
import java.nio.file.Files;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImage = "mona_lisa.jpg";
        String destinationImage = "copiedImage.jpg";

        try
        {
            // Convert image to byte array
            byte[] imageData = convertImageToByteArray(sourceImage);

            // Write byte array back to new image file
            writeByteArrayToImage(imageData, destinationImage);

            System.out.println("Image successfully copied!");
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static byte[] convertImageToByteArray(String imagePath) throws IOException
    {
        try (ByteArrayOutputStream outputResult = new ByteArrayOutputStream()) {
            Files.copy(new File(imagePath).toPath(), outputResult);
            return outputResult.toByteArray();
        }
    }

    private static void writeByteArrayToImage(byte[] imageData, String outputPath) throws IOException
    {
        try (ByteArrayInputStream sampleFile = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputPath))
        {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = sampleFile.read(buffer)) != -1)
            {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}

