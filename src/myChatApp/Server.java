package myChatApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started...");
        ServerSocket serverSocket = new ServerSocket(5001);
        //for clients two socket
        Socket client1=serverSocket.accept();
        System.out.println("Client 1 connected");

        Socket client2=serverSocket.accept();
        System.out.println("Client 2 connected");

        new ClientHandler(client1,client2);
        new ClientHandler(client2,client1);
    }
}
class ClientHandler implements Runnable {
    Socket FromClient;
    Socket ToClient;
    Thread t;
    ClientHandler(Socket FromClient, Socket ToClient){
        this.FromClient = FromClient;
        this.ToClient = ToClient;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
          try{
              ObjectInputStream in = new ObjectInputStream(FromClient.getInputStream());
              ObjectOutputStream out = new ObjectOutputStream(ToClient.getOutputStream());
              while(true){
                  String message = (String) in.readObject();
                  System.out.println("Message received: " + message);
                  out.writeObject(message);
                  out.flush();
              }

          }catch (Exception e){
              System.out.println(e.getMessage());
          }
    }


}