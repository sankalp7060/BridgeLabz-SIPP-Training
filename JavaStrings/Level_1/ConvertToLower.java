import java.util.*;

public class ConvertToLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String lower1 = convertToLower(s);     
        String lower2 = s.toLowerCase();    
        if (compare(lower1, lower2)) {
            System.out.println("Matched: " + lower1);
        } else {
            System.out.println("Not Matched");
        }
    }

    public static String convertToLower(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32); 
            } else {
                result += ch; 
            }
        }
        return result;
    }

    public static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
