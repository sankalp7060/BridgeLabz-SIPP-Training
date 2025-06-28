import java.util.*;

public class AverageOfElements{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a={1,2,3,4};
        double average=check(a); 
        System.out.print("Average of all elements:- "+average);
    }
    public static double check(int[] a){
      int sum=0;
      for(int i:a) sum+=i;
      return (double)sum/a.length;
    }
}