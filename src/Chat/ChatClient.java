package Chat;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Thread to listen for messages from server
        new Thread(() -> {
            String msg;
            try {
                while ((msg = in.readLine()) != null) {
                    System.out.println("Other: " + msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Send messages to server
        String clientMsg;
        while ((clientMsg = console.readLine()) != null) {
            out.println(clientMsg);
        }

        socket.close();
    }
}


