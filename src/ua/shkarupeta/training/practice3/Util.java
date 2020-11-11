package ua.shkarupeta.training.practice3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Util {

    private static final String ENCODING = "Cp1251";

    private Util(){
        throw new IllegalStateException("Utility class");
    }

    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }
}