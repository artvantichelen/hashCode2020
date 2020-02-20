import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        File file = new File(args[0]);

        try {
            FileReader fileReader = new FileReader(file);
            PrintWriter writer = new PrintWriter(args[1]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                writer.println(line);
                line = bufferedReader.readLine();
            }
            writer.close();
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
