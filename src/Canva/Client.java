package Canva;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Client() throws IOException {
        socket = new Socket("localhost", 12345);  // Connect to server
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());

        // Start thread to receive drawing data from server
        new Thread(this::receiveDrawingData).start();
    }

    private void receiveDrawingData() {
        try {
            while (true) {
                // Receive drawing data from server and update client canvas
                DrawingData data = (DrawingData) in.readObject();
                // Handle drawing update here, maybe update the client's canvas
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendDrawingData(DrawingData data) {
        try {
            out.writeObject(data);  // Send drawing data to server
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}
