package HashMap;

import java.util.HashMap;
import java.util.*;

public class Task {
    public static ArrayList<Integer> findStudentsByCourse(Map<Integer,List<String>> map,String course){
        ArrayList<Integer> students= new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry: map.entrySet()){
            if(entry.getValue().contains(course)){
                 students.add(entry.getKey());
            }
        }
        return students;
    }

    public static void main(String[] args) {
        Map<Integer, List<String>> studentCourses = new HashMap<>();
        studentCourses.put(1,new ArrayList<>(Arrays.asList("MATH","BIO")));
        studentCourses.put(2,new ArrayList<>(Arrays.asList("CSE","BBA","BIO")));
        studentCourses.put(3,new ArrayList<>(Arrays.asList("BIO","ECO")));

        System.out.println(studentCourses);
        List<Integer> enrolledinBio=findStudentsByCourse(studentCourses,"BIO");
        System.out.println(enrolledinBio);



    }
}
