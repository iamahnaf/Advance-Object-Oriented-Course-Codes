package PracticeProblemForFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopying {
    public static void main(String[] args) {
      String source="src.mp4";
      String dest="copy.mp4";
      //intialize inputstream and outputstream
        try{
            FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(dest);
            //total bytes
            long totalbytes = inputStream.available();
            long copybytes =0;
            // buffer for reading and writing
            byte[] buffer = new byte[1024];
            int byteread;
            //copying data
            while((byteread = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,byteread);
                copybytes=copybytes+byteread;

                //showing the copying
                double progress = (double) copybytes/totalbytes;
                System.out.printf("File copied %.2f %%\n", progress * 100);
            }
            System.out.println("File copy completed successfully");
            inputStream.close();
            outputStream.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
