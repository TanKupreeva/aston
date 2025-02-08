package random;

import java.io.*;

public class Util {

    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder(214748364);
        try {
            Reader reader = new BufferedReader(new FileReader(path), 214748364);
            int characterCode;
            while ((characterCode = reader.read()) != -1) {
                sb.append((char) characterCode);
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
