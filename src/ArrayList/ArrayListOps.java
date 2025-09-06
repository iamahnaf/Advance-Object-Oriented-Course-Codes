package ArrayList;

import java.util.*;

class Person implements Comparable<Person>{
    String name;
    int age;
    String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    void display(){
        System.out.println(name+" "+age+" "+address);
    }


    public int compareTo(Person o) {
       return 0;
    }
}
public class ArrayListOps {
    public static void main(String[] args) {
        List<Person> personList= new ArrayList<>();
        personList.add(new Person("Ahnaf",29,"Khilgaon"));
        personList.add(new Person("nafi",28,"Narayganj"));
        personList.add(new Person("Mosatakim",21,"Mautail"));
        personList.add(new Person("Messi",38,"USA"));
        //it
        Iterator<Person> it= personList.iterator();

        //sort
        //Collections.sort(personList);

        //comparator
        /*Collections.sort(personList, new Comparator<Person>() {

            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        */
        //
        Collections.sort(personList, (p1,p2) -> p1.age - p2.age);
        //print
        for(Person p : personList){
            p.display();
        }
       /*Person old=personList.get(personList.size()-1);
        System.out.println("Oldest age : ");
        old.display();
        */
        Person oldest=Collections.max(personList, Comparator.comparing(person -> person.age));


    }
}
