package customiterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestIterator {

    public static void main(String args[]) {
        ArrayList<String> animalList = new ArrayList<String>();
        animalList.add("Horse");
        animalList.add("Lion");
        animalList.add("Tiger");
        Animal animal = new Animal(animalList);
        for (String animalObj : animal) {
            System.out.println(animalObj);
        }
        Map map = new HashMap();
        map.put(new Animal(animalList), "str");
        map.put(new Animal(animalList), "strb");
        map.put(new Animal(animalList), "stra");
    }
}
