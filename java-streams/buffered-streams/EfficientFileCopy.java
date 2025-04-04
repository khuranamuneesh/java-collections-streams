
import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.dat";
        String destinationBuffered = "buffered_copy.dat";
        String destinationUnbuffered = "unbuffered_copy.dat";

        long bufferedTime = copyWithBufferedStreams(sourceFile, destinationBuffered);
        long unbufferedTime = copyWithUnbufferedStreams(sourceFile, destinationUnbuffered);

        System.out.println("Buffered Streams Time: " + bufferedTime + " ns");
        System.out.println("Unbuffered Streams Time: " + unbufferedTime + " ns");
    }

    private static long copyWithBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    private static long copyWithUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
