import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans="";
        int[] f=new int[256];
        for(int i=0;i<s.length();i++){
          char ch=s.charAt(i);
          if(f[ch]==0){
            ans+=ch;
            f[ch]=1;
          }
        }
        System.out.print(ans);
    }
}
 