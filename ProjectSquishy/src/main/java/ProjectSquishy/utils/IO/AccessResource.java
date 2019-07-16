package ProjectSquishy.utils.IO;

import org.apache.log4j.Logger;

import java.io.File;
import java.net.URL;

public class AccessResource {

    private Logger logger = org.apache.log4j.Logger.getLogger(AccessResource.class);

    public File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        return new File(resource.getFile());

    }
}
