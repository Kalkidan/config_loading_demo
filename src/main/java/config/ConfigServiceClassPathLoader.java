package config;

import java.io.IOException;
import java.io.InputStream;

public class ConfigServiceClassPathLoader implements ConfigServicePropertyProvider {

   //Default value for the class path
    private static String DEFAULT_PROPERTIES_FILE = "Couchbase.yml";

      //TODO:: change the default name if you don't like it :D
    private final String credentialsFilePath;

    /**
     * Customized value for loading.
     *
     */
    public ConfigServiceClassPathLoader(String credentialsFilePath){
        if (credentialsFilePath == null)
            throw new IllegalArgumentException("Invalid Credential path");

        // Make sure the path is absolute
        //Getting it ready for java I/O
        if (!credentialsFilePath.startsWith("/")) {
            this.credentialsFilePath = "/" + credentialsFilePath;
        } else {
            this.credentialsFilePath = credentialsFilePath;
        }
    }

    public ConfigServiceClassPathLoader(){
        this(DEFAULT_PROPERTIES_FILE);
    }

    @Override
    public ConfigServiceProperties getSdkConfigCredential() {

        InputStream inputStream = getClass().getResourceAsStream(credentialsFilePath);
        if (inputStream == null) {
           //TODO:: throw appropriate exception
        }

        try {
            return new ConfigServicePropertyExtractor(inputStream);
        } catch (IOException e) {
            //TODO:: throw appropriate exception
        }
        return null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + credentialsFilePath + ")";
    }
}
