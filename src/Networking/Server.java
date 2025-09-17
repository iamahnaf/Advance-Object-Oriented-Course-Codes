package Networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //making server
        ServerSocket serverSocket = new ServerSocket(5002);
        System.out.println("Server started..");
        while (true) {
            //creating socket so it can handle a clinet
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");
            //for comms need input and outputstream
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            //for receiving need object input
            try {
                Object cmsg= objectInputStream.readObject();
                System.out.println("For client: "+cmsg);
                String serverMsg = (String) cmsg;
                //making it uppcase
                serverMsg=serverMsg.toUpperCase();
                //sending it to client
                objectOutputStream.writeObject(serverMsg);

            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
