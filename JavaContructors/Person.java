public class Person{
  private String name;
  private int age;
  public Person(String name,int age){
    this.name=name;
    this.age=age;
  }
  public Person(Person other){
    this(other.name,other.age);
  }
}