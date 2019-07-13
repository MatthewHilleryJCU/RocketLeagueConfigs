package ProjectSquishy.utils.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserIO {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Hello whats your name?");
        String name = s.nextLine();
        System.out.println(name);
    }
}
