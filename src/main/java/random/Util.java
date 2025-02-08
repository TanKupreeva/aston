package random;

import java.io.*;

public class Util {
    public static int genRandom(int maxBound) {
        return genRandom(0, maxBound);
    }

    public static int genRandom(int minBound, int maxBound) {
        //TODO :
        int v = maxBound - minBound + 1;
        int x = (int) (Math.random() * v) + minBound;
        return x < 0 ? x * (-1) : x;
    }
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
