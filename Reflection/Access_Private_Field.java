import java.lang.reflect.Field;

class Person {
    private int age = 25;
}

public class Access_Private_Field {
    public static void main(String[] args) throws Exception {
        Person person = new Person();

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Original Age: " + ageField.get(person));

        ageField.set(person, 30);
        System.out.println("Modified Age: " + ageField.get(person));
    }
}
