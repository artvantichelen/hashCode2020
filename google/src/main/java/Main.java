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
            int lineNumber = 1;
            while (lineNumber < 3) {
                if (lineNumber == 1) {
                    String[] tabString = line.split(" ");
                    writer.println(line);
                }
                if (lineNumber == 2) {
                    String[] tabString = line.split(" ");
                    line = bufferedReader.readLine();
                    writer.println(line);
                }
                lineNumber++;
            }
            writer.println(line);
            writer.close();
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
