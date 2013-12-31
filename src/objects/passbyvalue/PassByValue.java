package objects.passbyvalue;

/**
 * Objects are passed by reference and reference itself is passed as value in Java.
 * User: rpanjrath
 * Date: 9/20/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PassByValue {

    public static void main(String[] args) {
        Dog dog = new Dog("ABC");
        dog.foo(dog);
        System.out.println(dog.getName());
    }
}
