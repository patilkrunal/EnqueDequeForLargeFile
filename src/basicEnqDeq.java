import java.io.*;
import java.util.ArrayList;

public class basicEnqDeq {
    private static final String FILE_NAME = "/Users/krunal/Downloads/basicEnqDeq/src/numbers.txt";
    static ArrayList<Integer> data = new ArrayList<>();

    private static int size, front, rear;

    public static void enqueue(int n) {
        System.out.println(" rear " + rear);
        data.add(rear, n);
        rear = (rear + 1) % data.size();
        size++;
    }

    public static int dequeue(ArrayList<Integer> data) {
        if (size == 0) {
            throw new RuntimeException("Queue is empty.");
        }
        System.out.println(" front " + front);
        int e = data.get(front);
        front = (front + 1) % data.size();
        size--;
        return e;
    }

     static void readfile() throws IOException {
        try {
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(new FileReader(FILE_NAME)));
            st.parseNumbers();
            st.nextToken();
            while (st.ttype != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    enqueue((int) st.nval);
                } else
                    System.out.println("Non number: " + st.sval);
                st.nextToken();
            }

            System.out.println("Size1: " + data.size());

//            for(int i=0; i<1; i++){

            long startTime1 = System.nanoTime();
            dequeue(data);
            long endTime1 = System.nanoTime();

            System.out.println("Size2: " + data.size());
            System.out.println(String.format("Total time by StreamTokenizer with BufferedReader: %d ns", endTime1 - startTime1));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        readfile();
        long endTime = System.nanoTime();
        System.out.println(String.format("Total time %d ms", endTime - startTime));

    }
}
