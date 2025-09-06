package Stactic;

public class MathOperations {
   public static int findAverage(int[] arr){
       int average = 0;
       for (int j : arr) {
           average += j;
       }
     return average / arr.length;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int ans=findAverage(arr);
        System.out.println(ans);
    }
}
