package ProjectSquishy.utils.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class AccessResource {
    public File getFile(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        }else{
            return  new File(resource.getFile());
        }
    }

    public void printFile(File file) throws IOException{
        if (file == null) return;
        try (FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader)){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
    }
}
