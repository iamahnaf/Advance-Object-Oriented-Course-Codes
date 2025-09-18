package ChatAppUsingThread;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client Started");
        //for connecting to server using ip and port
        Socket socket = new Socket("localhost",5001);
        System.out.println("Client connected");

        //now for comms object input and output stream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        new ReaderThread(objectInputStream,"Client 1");
        new WriterThread(objectOutputStream,"Client 1");


        //socket.close();
    }
}
class ReaderThread implements Runnable{
     ObjectInputStream objectInputStream;
     String name;
     Thread t;
    ReaderThread(ObjectInputStream objectInputStream,String name){
        this.objectInputStream = objectInputStream;
        this.name = name;
        t = new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        while(true){

            //receiving msg from server
            try {
                Object received=objectInputStream.readObject();
                System.out.println(name+" got:  "+(String) received);
            } catch (ClassNotFoundException | IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
class WriterThread implements Runnable{
     ObjectOutputStream objectOutputStream;
     String name;
     Thread t;
     WriterThread(ObjectOutputStream objectOutputStream,String name){
         this.objectOutputStream = objectOutputStream;
         this.name = name;
         t = new Thread(this);
         t.start();
     }
    @Override
    public void run() {
         Scanner scanner = new Scanner(System.in);

        while(true){
            String message = scanner.nextLine();
            try {
                objectOutputStream.writeObject(message);
                System.out.println("Message sent...");
            } catch (IOException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
