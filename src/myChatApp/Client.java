// Corrected Client.java
package myChatApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started..");
        Socket socket = new Socket("localhost", 5001);

        // Correctly handle the order to prevent deadlock
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        Scanner scanner = new Scanner(System.in);

        // Pass the streams to the handler
        new ServerHandler(objectInputStream);

        while (true) {
            String message = scanner.nextLine();
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        }
    }
}

class ServerHandler implements Runnable {
    ObjectInputStream objectInputStream;
    Thread t;

    ServerHandler(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = (String) objectInputStream.readObject();
                System.out.println("From Another Client: " + message);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}