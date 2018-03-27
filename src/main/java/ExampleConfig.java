import config.ConfigServiceClassPathLoader;
import config.ConfigServicePropertyProvider;

import java.util.logging.Logger;

public class ExampleConfig {


    public static final String LOGGER = ExampleConfig.class.getSimpleName();
    //Example to demo
    public static void main(String[] args){


        ConfigServicePropertyProvider sdkConfigCredentialProvider = new ConfigServiceClassPathLoader();

        if(sdkConfigCredentialProvider!= null){

            Logger.getLogger(LOGGER).info("The port is \t \t " + sdkConfigCredentialProvider.getSdkConfigCredential().getPort());
            Logger.getLogger(LOGGER).info("The host is \t \t " + sdkConfigCredentialProvider.getSdkConfigCredential().getHost());
            Logger.getLogger(LOGGER).info("The bucket name is \t \t " + sdkConfigCredentialProvider.getSdkConfigCredential().getBucketName());

        }
    }
}
