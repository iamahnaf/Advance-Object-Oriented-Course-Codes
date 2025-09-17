package PracticeProblemForFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class CharFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "input1.txt";
        System.out.println("Character Frequency: ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(str));
            int[] arr= new int[128];
            int x;
            while( (x = br.read())!= -1) {
                if((x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z')) {
                    arr[x]++;
                }
            }
            br.close();

            //printing

            for(int i=0;i<arr.length;i++){
                char c= (char)i;
                if(arr[c]>0){
                    System.out.println(c+" "+arr[i]);
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
