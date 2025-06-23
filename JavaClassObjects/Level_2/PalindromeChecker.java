import java.util.*;
public class PalindromeChecker{
  private String text;
  public PalindromeChecker(String text){
    this.text=text;
  }
  public boolean isPalindrome(){
    int i=0,j=text.length()-1;
    while(i<j){
      if(text.charAt(i)!=text.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }
  public void display(){
    if(isPalindrome(text)) System.out.print("Given text is palindrome");
    else System.out.print("Given text is not a palindrome");
  }
  public static void main(String[] args){
    String text="aba";
    PalindromeChecker palindrome=new PalindromeChecker(text);
    palindrome.display();
  }
}