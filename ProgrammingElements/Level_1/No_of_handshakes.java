import java.util.*;
public class No_of_handshakes{
  public static void main(String[] args){
    System.out.print("No of Students = ");
    Scanner sc=new Scanner(System.in);
    int numberOfStudents=sc.nextInt();
    int total_handshakes= (numberOfStudents * (numberOfStudents - 1)) / 2;;
    System.out.println("The maximum number of possible handshakes is: " + total_handshakes);
  }
}