package FILEcreating;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file= new File("notes.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
