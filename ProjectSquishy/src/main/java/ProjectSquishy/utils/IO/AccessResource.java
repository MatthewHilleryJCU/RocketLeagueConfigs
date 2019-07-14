package ProjectSquishy.utils.IO;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;

public class AccessResource {

    private Logger logger = org.apache.log4j.Logger.getLogger(AccessResource.class);

    public File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        return new File(resource.getFile());
    }

    public void printFile(File file) {
        if (file != null) {
            try {
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);

                while ((br.readLine()) != null) {
                    System.out.println(br.readLine());
                }

            } catch (FileNotFoundException e) {
                logger.error("File not found: " + file);

            } catch (IOException e) {
                logger.error("File cannot be read: " + file);
            }
        }
    }
}
