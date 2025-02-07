package random;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Random {


    public static String readFileByLines(String path) {
        StringBuilder sb = new StringBuilder(214748364);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path), 214748364);
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check you file path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
