package ProjectSquishy.utils.IO;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileReaderWriter {

    public void write(BufferedWriter bw, String line) {
        try (BufferedWriter writer = bw){
            writer.write(line);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(BufferedReader br) {

        try (BufferedReader reader = br) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

}