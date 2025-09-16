package BufferReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //byte to char stream then reading char stream
        System.out.println("You type: "+br.readLine());// working like scanner(System.in);
        //from keyboard
    }
}
