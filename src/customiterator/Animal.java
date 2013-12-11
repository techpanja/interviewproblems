package customiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rpanjrath
 * Date: 9/12/13
 * Time: 1:36 PM
 */
public class Animal implements Iterable<String> {

    private List<Animal> animalList = new ArrayList<Animal>();

    public Animal(List animalList) {
        this.animalList = animalList;
    }

    public List getAnimal() {
        return animalList;
    }

    @Override
    public Iterator<String> iterator() {
        return new AnimalIterator(this);
    }
}
