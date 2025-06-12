public class Pen_distribution{
  public static void main(String[] args){
    int number_of_pens=14;
    int number_of_students=3;
    int distributed_pens=number_of_pens/number_of_students;
    int non_distributed_pens= number_of_pens%number_of_students;
    System.out.println("The Pen Per Student is " + distributed_pens + 
                           " and the remaining pen not distributed is " + non_distributed_pens);
  }
}