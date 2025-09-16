package WritingFile;


//close
//flush

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            FileWriter fw=new FileWriter("notes.txt",true);
            fw.write("\nyou are fat");
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
