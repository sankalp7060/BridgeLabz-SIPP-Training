import java.util.ArrayList;

public class Suppress_Unchecked_Warnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();  // raw type, normally gives warning
        list.add("Hello");
        list.add(123);
        System.out.println(list);
    }
}
