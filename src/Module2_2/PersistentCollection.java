package Module2_2;


import java.util.ArrayList;
import java.util.List;

public class PersistentCollection {
    private final int size;
    List<Integer> list;

    PersistentCollection() {
        size = 16;
        list = new ArrayList<Integer>(size);
    }

    PersistentCollection(Integer size) {
        this.size = size;
        list = new ArrayList<Integer>(size);
    }

    public void add(Integer element) {
        if (list.size() == size) {
            list.remove(0);
        }
        list.add(element);

    }

    @Override
    public String toString() {
        return "PersistentCollection{" + list + '}';
    }
}
