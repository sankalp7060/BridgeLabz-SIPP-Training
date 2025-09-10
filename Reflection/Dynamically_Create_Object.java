import java.lang.reflect.Constructor;

class Student {
    String name;

    public Student() {
        this.name = "Default Student";
    }
}

public class Dynamically_Create_Object {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Student.class;

        Constructor<?> constructor = clazz.getConstructor();
        Object obj = constructor.newInstance();

        Student student = (Student) obj;
        System.out.println("Student Created: " + student.name);
    }
}
