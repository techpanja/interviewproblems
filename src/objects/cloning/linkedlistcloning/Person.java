package objects.cloning.linkedlistcloning;

/**
 * Created with IntelliJ IDEA.
 * User: rpanjrath
 * Date: 11/20/13
 * Time: 1:51 PM
 */
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
