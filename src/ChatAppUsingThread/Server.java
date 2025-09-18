package ChatAppUsingThread;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //making server
        //ServerSocket class socket ke ip dei for connecting
        ServerSocket serverSocket = new ServerSocket(5001);
        System.out.println("Server started..");
        while (true) {
            //creating socket so it can handle a clinet
            //socket takes connection from clinet
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            //new server thread start
             new ServerThread(socket);

        }
    }
}
class ServerThread implements Runnable {
    Socket clientSocket; Thread t;
    ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        t= new Thread(this);
        t.start();
    }
    @Override
    public void run() {

        try {
            //for comms need input and outputstream
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            //for receiving need object input
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
           while (true) {
               //read from client socket
               Object cmsg= objectInputStream.readObject();
               if(cmsg == null){
                   break;
               }
               System.out.println("For client: "+cmsg);
               String serverMsg = (String) cmsg;

               //making it uppcase
               serverMsg=serverMsg.toUpperCase();

               //sending it to client
               objectOutputStream.writeObject(serverMsg);
           }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}