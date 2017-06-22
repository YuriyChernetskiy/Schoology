package Module3_1;

public class Main {
    public static void main(String[] args) {
        TestingCollection tc = new TestingCollection();
        tc.addElement(null);

        tc.getByElement(null);

        tc.minElement();

        tc.maxElement();

        tc.average();

        tc.addElement(456);
        tc.addElement(34);
        tc.addElement(16);
        tc.addElement(1);
        tc.addElement(26);
        tc.addElement(356);
        tc.addElement(1);

        tc.getByIndex(456);

        tc.getByElement(78);

        tc.minElement();

        tc.maxElement();

        tc.average();

        System.out.println(tc.toString());


    }
}
