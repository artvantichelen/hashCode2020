import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class MainTest {

    @Test
    public void shouldReturnExampleResponse_whenExampleInputIsSend() {
        String inputFilePath = "src/test/resources/input/a_example.in";
        String outputFilePath = "src/test/resources/output/a_example_result.in";
        String[] args = { inputFilePath, outputFilePath };
        File fileExpected = new File("src/test/resources/output/a_example_result_expected.in");
        String line1Expected;
        String line2Expected;
        try {
            FileReader fileReader = new FileReader(fileExpected);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line1Expected = bufferedReader.readLine();
            line2Expected = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            line1Expected = "can not find expected";
            line2Expected = "can not read expected";
        }

        Main.main(args);
        File file = new File(outputFilePath);
        String line1;
        String line2;
        String line3 = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line1 = bufferedReader.readLine();
            line2 = bufferedReader.readLine();
            line3 = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            line1 = "can not find result";
            line2 = "can not read result";
        }

        assert(line1).equals(line1Expected);
        assert(line2).equals(line2Expected);
        assert(line3 == null);

    }
}