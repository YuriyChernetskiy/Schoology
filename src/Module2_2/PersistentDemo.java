package Module2_2;

public class PersistentDemo {
    public static void main(String[] args) {
        PersistentCollection pc = new PersistentCollection(25);

        for (int i=0; i<30; i++){
            pc.add(i);
        }

        System.out.println(pc.toString());
    }
}
