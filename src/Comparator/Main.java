package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
   public static Comparator<Integer> comparator=new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 % 2==0){
                return -1;
            }else if(o2 % 2==0){
                return 1;
            }else return 0;
        }
    };
    public static void main(String[] args) {

        List<Integer> list=new ArrayList<>();
        list.add(20);
        list.add(21);
        list.add(5);
        list.add(8);
        System.out.println(list);


        Collections.sort(list,comparator);
        System.out.println(list);


    }
}
