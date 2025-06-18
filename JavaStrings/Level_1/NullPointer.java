import java.util.*;
public class NullPointer{
  public static void main(String[] args){
    handleException();
  }
  public static void handleException(){
    String s=null;
    try{
      System.out.print(s.length());
    }catch(NullPointerException e){
      System.out.print(e.getMessage());
    }
  }
}