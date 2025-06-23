import java.util.*;

public class ReplaceCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string:- ");
        String s = sc.nextLine();
        System.out.print("Enter character to replace:- ");
        char ch=sc.next().charAt(0);
        String result = s.replace(String.valueOf(ch), "");;
        System.out.print(result);
    }
}
