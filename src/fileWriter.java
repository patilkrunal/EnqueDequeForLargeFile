import java.io.*;

public class fileWriter {

    static void fileWriterfun(){
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/krunal/Downloads/basicEnqDeq/src/numbers.txt"), "utf-8"));
            for(int i=1, j=1; i<=160000; i++){
                writer.write(j++ + ",");
                if(i%100000 == 0) {
                    writer.write("\n");
                }
            }

        } catch(IOException ex) {}
        finally {
            try { writer.close(); } catch (Exception ex) {}
        }
    }

    public static void main(String[] args) throws Exception {
        fileWriterfun();
    }
}
