package objects.immutableclass;

import java.util.ArrayList;
import java.util.List;

/**
 * Make a class immutable.
 * http://javarevisited.blogspot.com/2013/03/how-to-create-immutable-class-object-java-example-tutorial.html
 * User: rpanjrath
 * Date: 10/22/13
 * Time: 4:02 PM
 */
public final class ImmutableClass {

    // make all variables final
    private final int anInt;
    private final String string;

    // making list final won't make it immutable. You can use getList and then perform add on it.
    private final List<String> list;

    public ImmutableClass(int anInt, String string, List<String> list) {
        this.anInt = anInt;
        this.string = string;
        this.list = list;
    }


    public int getAnInt() {
        return anInt;
    }

    public String getString() {
        return string;
    }

    public List<String> getList() {
        List tempList = new ArrayList();
        tempList.addAll(list);
        return tempList;
    }

    // REMOVE ALL SETTERS
    /*
    public void setString(String string) {
        this.string = string;
    }

    public void setAnInt(int i) {
        this.anInt = i;
    }

    public void setList(List list) {
        this.list = list;
    }
    */
}
