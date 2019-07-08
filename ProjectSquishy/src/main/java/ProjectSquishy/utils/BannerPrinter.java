package ProjectSquishy.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BannerPrinter {

    public void print () {

        try {
            File f = new File("src/main/resources/banner.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
