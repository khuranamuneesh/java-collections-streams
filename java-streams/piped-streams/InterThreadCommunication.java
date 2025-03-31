import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream obj1;

    public WriterThread(PipedOutputStream pos) {
        this.obj1 = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello World! I am trying inter thread communication";
            obj1.write(message.getBytes());
            obj1.close();
        } catch (IOException e)
        {
            System.out.println("Writer error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream obj2;

    public ReaderThread(PipedInputStream pis) {
        this.obj2 = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = obj2.read()) != -1)
            {
                System.out.print((char) data);
            }
            obj2.close();
        } catch (IOException e)
        {
            System.out.println("Reading error due to : " + e.getMessage());
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();
        }
        catch (IOException e)
        {
            System.out.println("Pipe error: " + e.getMessage());
        }
    }
}
