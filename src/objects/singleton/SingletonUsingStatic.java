package objects.singleton;

/**
 * Singleton pattern example with static factory method
 * Eagerly initialized.
 * User: rpanjrath
 * Date: 10/15/13
 * Time: 12:21 PM
 */
public class SingletonUsingStatic {

    private static final SingletonUsingStatic SINGLETON_USING_STATIC = new SingletonUsingStatic();

    private SingletonUsingStatic() {
    }

    public static SingletonUsingStatic getInstance() {
        return SINGLETON_USING_STATIC;
    }

}
