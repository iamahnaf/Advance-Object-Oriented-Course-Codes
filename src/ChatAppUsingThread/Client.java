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
        Socket socket = new Socket("localhost",5002);
        System.out.println("Client connected");
        //now for comms object input and output stream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        //for taking input from user for clinet msg
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //sending msg to server
        objectOutputStream.writeObject(input);
        //receiving msg from server
        try {
            Object object=objectInputStream.readObject();
            System.out.println("From server: "+(String) object);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

