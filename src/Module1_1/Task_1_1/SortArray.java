package Module1_1.Task_1_1;

 class SortArray {

        private int[] mass;
        private int nElems;
        int massSize;

        public SortArray(int size) {
            massSize = size;
            mass = new int[size];
            nElems = 0;
        }

        public void insert(int num) {
            mass[nElems] = num;
            nElems++;
        }

        public void sort() {
            int in, out;
            for (out = nElems - 1; out > 0; out--)
                for (in = 0; in < out; in++)
                    if (mass[in] > mass[in + 1]) {
                        int temp = mass[in];
                        mass[in] = mass[in+1];
                        mass[in+1] = temp;
                    }
        }

        public void display() {
            for (int j = 0; j < nElems; j++)
                System.out.print(mass[j] + " ");
            System.out.println("");
        }
    }
