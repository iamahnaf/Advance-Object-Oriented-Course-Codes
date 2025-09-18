package GroupChat;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    public static List<ObjectOutputStream> clientOutputStreams = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("Server started...");
        ServerSocket serverSocket = new ServerSocket(5001);
        //loop for getting multiple clients accept
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection from " + socket.getRemoteSocketAddress());
          new ClientHandler(socket,clientOutputStreams);
        }
    }
}
class ClientHandler implements Runnable {
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
   List<ObjectOutputStream> clientOutputStreams;
    Thread t;
    ClientHandler(Socket socket, List<ObjectOutputStream> list){
        this.socket = socket;
        clientOutputStreams = list;
        try{
            //socket tar output ready korlam
            out = new ObjectOutputStream(socket.getOutputStream());
            //socket ta ke list e raklam
            //socket er output ke list e raklam , output gular list e

            clientOutputStreams.add(out);
            in = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try{

            while(true){
                //single socket ta msg dilo ata receive korlam
                String message = (String) in.readObject();
                System.out.println("Message received: " + message);
               //broadcasting to all clinets, sobaike pathailm except nijeke
               for (ObjectOutputStream o : clientOutputStreams){
                   if(o != this.out){
                       try{
                           o.writeObject(message);
                           o.flush();
                       }catch (Exception e){
                           System.out.println(e.getMessage());
                       }
                   }
               }

            }

        }catch (Exception e){
            System.out.println("client disconnected...");
        }finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


}