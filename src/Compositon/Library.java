package Compositon;

import java.util.ArrayList;
import java.util.List;

class Book{
    String title;
    String author;


    int ISBN;
    Book(String title, String author, int ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
}

public class Library {
     List<Book> books=new ArrayList<>();
     //add
     void addBook(String title,String author, int num)
     {
         books.add(new Book(title,author,num));
     }
     void removeBook(int isbn){
         boolean found = false;
         for(Book it : books){
             if(it.ISBN==isbn){
                  found=true;
                 books.remove(it);
                  break;
             }
         }
         if(found){
             System.out.println("Book has been removed with the ISBN of "+isbn);
         }else{
             System.out.println("We couldnt Find the boook with this ISBN "+isbn);
         }
     }
     void display(){
         if(books.isEmpty()){
             System.out.println("No Book in the library");
         }
         for(Book it: books){
             System.out.println("Title : "+it.title+"\n Author : "+it.author+" \n ISBN : "+it.ISBN);
         }
     }

}
