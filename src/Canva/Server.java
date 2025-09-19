package Canva;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Server() throws IOException {
        serverSocket = new ServerSocket(12345);  // Listening on port 12345
        clientSocket = serverSocket.accept();    // Accept client connection
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        in = new ObjectInputStream(clientSocket.getInputStream());

        // Start thread to listen to drawing data from client
        new Thread(this::receiveDrawingData).start();
    }

    private void receiveDrawingData() {
        try {
            while (true) {
                // Receive drawing data from client (assumed data format)
                DrawingData data = (DrawingData) in.readObject();
                // Handle drawing update here, maybe update the server's canvas
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendDrawingData(DrawingData data) {
        try {
            out.writeObject(data);  // Send drawing data to client
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
