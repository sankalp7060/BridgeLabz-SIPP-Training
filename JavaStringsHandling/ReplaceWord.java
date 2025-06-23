import java.util.*;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sentence:- ");
        String s = sc.nextLine();
        System.out.print("Enter the old word:- ");
        String oldWord=sc.next();
        System.out.print("Enter the new word:- ");
        String newWord=sc.next();
        String result = "";
        String[] words=s.split("\\s");
        for(int i=0;i<words.length;i++){
          if(words[i]==oldWord) result+=newWord;
          else result+=words[i];
          if(i!=words.length-1) result+=" ";
        }
        System.out.print(result);
    }
}
