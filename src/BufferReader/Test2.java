package BufferReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    public static void main(String[] args) {
     try{
    BufferedReader br = new BufferedReader(new FileReader("note.txt"));

    while(br.ready()){
        System.out.println(br.readLine());
    }

     }catch (Exception e){
         System.out.println(e.getMessage());
     }

    }
}
