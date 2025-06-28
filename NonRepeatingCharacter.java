import java.util.*;

public class NonRepeatingCharacter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char ans=' ';
        int[] f=new int[256];
        for(char i:s.toCharArray()) f[i]++;
        for(int i=0;i<s.length();i++){
          if(f[s.charAt(i)]==1){
            System.out.print("first non repeating character:- "+s.charAt(i));
            break;
          }
        }
    }
}