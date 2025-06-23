import java.util.*;

public class CountVowelsConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int vowels=0;
        int consonants=0;
        for(char i:s.toCharArray()){
          if(i=='a' || i=='e'|| i=='i'|| i=='o' ||i=='u') vowels++;
          else{
            consonants++;
          }
        }
        System.out.print("Vowels:- "+vowels+" Consonants:- "+consonants);
    }
}
