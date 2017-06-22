package Module3_1;

import java.util.ArrayList;
import java.util.Comparator;

public class TestingCollection {
    ArrayList<Integer> arrayList;

    public TestingCollection() {
        arrayList = new ArrayList<Integer>();
    }

    public TestingCollection(int i) {
        arrayList = new ArrayList<Integer>(i);
    }

    public void addElement(Integer el) {
        if (el == null) {
            System.out.println("Нельзя передавать пустое значение!!!");
        } else {
            arrayList.add(el);
            for (int i = 0; i < arrayList.size() - 1; i++) {
                arrayList.set(i, (arrayList.get(i) + el));
            }
        }
    }

    public void removeElement(Integer el) {
        if (arrayList.contains(el)) {
            arrayList.remove(el);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.set(i, (arrayList.get(i) - el));
            }
        }
        System.out.println("Данный элемент отсутствует в списке.");
    }

    public void getByIndex(int index) {
        try {
            System.out.println(arrayList.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс не входит в диапазон списка");
        }
    }

    public void getByElement(Integer element) {
        int result = arrayList.indexOf(element);

        try {
            if (result > 0) {
                System.out.println("Элемент имеет индекс: " + result);
            } else {
                System.out.println("Элемент не найден");
            }
        } catch (NullPointerException e) {
            System.out.println("Нельзя передавать пустое значение!!!");
        }


    }

    public void minElement() {
        try {
            arrayList.subList(0, arrayList.size());
            arrayList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            System.out.println(arrayList.get(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Список не имеет элементов, наполните его!!!");
        }
    }

    public void maxElement() {
        try {
            arrayList.subList(0, arrayList.size());
            arrayList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            System.out.println(arrayList.get(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Список не имеет элементов, наполните его!!!");
        }
    }

    public void average() {
        try {
            int sum = 0;
            for (int i : arrayList) {
                sum += i;
            }
            System.out.println(sum / arrayList.size());
        } catch (IndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Список не имеет элементов, наполните его!!!");
        }
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == arrayList.size() - 1) {
                str += arrayList.get(i) + "]";
            } else {
                str += arrayList.get(i) + ",";
            }
        }
        return str;
    }
}
