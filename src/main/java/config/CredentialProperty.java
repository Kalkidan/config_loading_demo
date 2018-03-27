package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Deals with credentials
public class CredentialProperty implements SdkConfigCredential{

    //
    private String host;
    //
    private String bucketName;
    //
    private String port;

    public CredentialProperty(InputStream inputStream) throws IOException {
        Properties accountProperties = new Properties();
        try {
            accountProperties.load(inputStream);
        } finally {
            try {inputStream.close();} catch (Exception e) {}
        }

        if (accountProperties.getProperty("host") == null ||
                accountProperties.getProperty("bucketName") == null ||
                accountProperties.getProperty("port") == null) {
            throw new IllegalArgumentException("The specified properties data " +
                    "doesn't contain the expected properties 'host', 'bucketName', and 'port'");
        }

        //
        host = accountProperties.getProperty("host");
        //
        bucketName = accountProperties.getProperty("bucketName");
        //
        port = accountProperties.getProperty("port");
    }


    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public String getBucketName() {
        return this.bucketName;
    }

    @Override
    public String getPort() {
        return this.port;
    }
}
