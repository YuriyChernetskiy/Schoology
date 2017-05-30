package Module2_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class DataOperations {
    List<Integer> list = new ArrayList<Integer>();

    public void add(int element) {
        if (list.isEmpty())
            list.add(element);
        else {
            list.add(element);
            for (int i = 0; i <= list.size() - 2; i++)
                list.set(i, (list.get(i) + element));
        }
    }

    public void remove(Integer element) {
        if (list.isEmpty())
            throw new NoSuchElementException();
        else if (!list.contains(element))
            System.out.println("NoSuchElement in Data");
        else {
            int reduce = element;
            list.remove(element);
            for (int i = 0; i < list.size(); i++)
                list.set(i, (list.get(i) - reduce));
        }
    }

    public void findByIndex(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        } else
            System.out.println(list.get(index));
    }

    public void findByElement(int element) {
        if (list.contains(element))
            System.out.println(element);
        else
            System.out.println("NoSuchElement in Data");
    }

    public void findMaxElement() {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list.get(list.size() - 1));
    }

    public void findMinElement() {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list.get(0));
    }

    public void average() {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum / list.size());

    }

    @Override
    public String toString() {
        return "DataOperations{" + list + '}';
    }
}
