package customiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Custom Iterator.
 * User: rpanjrath
 * Date: 9/12/13
 * Time: 1:32 PM
 */
public class AnimalIterator implements Iterator {

    List<?> animalList = new ArrayList();
    private static int position;

    public AnimalIterator(Animal animal) {
        this.animalList = animal.getAnimal();
    }

    @Override
    public boolean hasNext() {
        if (position < animalList.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object object = animalList.get(position);
        position++;
        return object;
    }

    @Override
    public void remove() {
        animalList.remove(position);
    }
}
