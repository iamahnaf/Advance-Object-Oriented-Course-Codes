package FileReader;

import java.io.FileReader;

public class FileReaderLearn {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("notes.txt");
        int first = fr.read();
        System.out.println(first);// FileReader returns -1 if there is no last digit
        while (first != -1) {
            System.out.print((char) first);
            first = fr.read();
        }
        fr.close();
    }
}
