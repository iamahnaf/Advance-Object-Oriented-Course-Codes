package Chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static List<PrintWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started, waiting for clients...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            clientWriters.add(out);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Thread to listen for this client's messages
            new Thread(() -> {
                String msg;
                try {
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Received: " + msg);
                        // Forward to all other clients
                        for (PrintWriter writer : clientWriters) {
                            if (writer != out) {
                                writer.println(msg);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    clientWriters.remove(out);
                    try { clientSocket.close(); } catch (IOException e) {}
                }
            }).start();
        }
    }
}
