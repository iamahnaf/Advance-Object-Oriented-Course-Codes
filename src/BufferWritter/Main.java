package BufferWritter;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("notes.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter("notes.txt",true));
            bw.write("im from nsu ");
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
