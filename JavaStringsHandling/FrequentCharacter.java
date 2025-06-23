import java.util.*;

public class FrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] f=new int[256];
        for(char i:s.toCharArray()) f[i]++;
        int count = f[s.charAt(0)];
        char mostFrequent = s.charAt(0);
        for(int i=1;i<s.length();i++){
          if(f[s.charAt(i)]>count){
            count=f[s.charAt(i)];
            mostFrequent=s.charAt(i);
          }
        }
        System.out.print(mostFrequent);
    }
}
