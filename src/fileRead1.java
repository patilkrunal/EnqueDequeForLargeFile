import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.text.SimpleDateFormat;
import java.util.*;

public class fileRead1 {
    private static final String FILE_NAME = "/Users/krunal/Downloads/basicEnqDeq/src/numbers.txt";
    static Queue<Integer> data1 = new LinkedList<>();

     static void readfile() throws IOException {
        try {



            StreamTokenizer st = new StreamTokenizer(new BufferedReader(new FileReader(FILE_NAME)));
            st.parseNumbers();
            st.nextToken();

            System.out.println("Enque started at " +
                    new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSSSSSS").format(Calendar.getInstance().getTime()));
            long startTime2 = System.currentTimeMillis();
            int k=0;
            while (st.ttype != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    if(k<10) {
                        System.out.println("enque " + k + " at " +
                                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSSSSSS").format(Calendar.getInstance().getTime()));
                    }
                    data1.add((int) st.nval);
                    k++;
                }
//                else System.out.println("Non number: " + st.sval);
                st.nextToken();
            }
            System.out.println("Enque finished at " +
                    new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSSSSSS").format(Calendar.getInstance().getTime()));
            long endTime2 = System.currentTimeMillis();
            System.out.println(String.format("Total time for enque is %d ns", endTime2 - startTime2));

            System.out.println("Size before deque: " + data1.size());

            long startTime1 = System.currentTimeMillis();
//            int no = data1.peek();  // returns first

            long startTime = System.nanoTime();
            for (int i = 0; i < 5; i++){
                System.out.println("deque " +i + " at " +
                        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSSSSSS").format(Calendar.getInstance().getTime()));
                data1.remove();  // removes first
            }
            long endTime = System.nanoTime();
            System.out.println(String.format("Total time for deque 5 times is %d ns", endTime - startTime));
            long endTime1 = System.currentTimeMillis();

            System.out.println("Size after deque: " + data1.size());
            System.out.println(String.format("Total time by StreamTokenizer with BufferedReader: %d ns", endTime1 - startTime1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        readfile();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Total time %d ms", endTime - startTime));
    }
}
