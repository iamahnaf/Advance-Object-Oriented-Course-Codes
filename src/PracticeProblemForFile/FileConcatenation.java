package PracticeProblemForFile;

import java.io.*;
import java.util.Scanner;

public class FileConcatenation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first file name: ");
        String file1=sc.nextLine();
        System.out.println("Enter the second file name: ");
        String file2=sc.nextLine();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
           String text1= br.readLine();
           br = new BufferedReader(new FileReader(file2));
           String text2= br.readLine();
            BufferedWriter bw= new BufferedWriter(new FileWriter("output.txt"));
            bw.write(text1);
            bw.newLine();
            bw.write(text2);

            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
