package Compositon;

public class Main {
    public static void main(String[] args) {
        Library library=new Library();
        library.addBook("HarryPoter","Md Shakil",23);
        library.addBook("Ayna","Humain Ahmen",99);
        library.addBook("Ami Chakin","Ahnaf",01);

        library.removeBook(23);

        library.display();
    }
}
