import config.SdkConfigClassPathLoader;
import config.SdkConfigCredentialProvider;

import java.util.logging.Logger;

public class ExampleConfig {


    public static final String LOGGER = ExampleConfig.class.getSimpleName();
    //Example to demo
    public static void main(String[] args){


        SdkConfigCredentialProvider  sdkConfigCredentialProvider = new SdkConfigClassPathLoader();

        if(sdkConfigCredentialProvider!= null){

            Logger.getLogger(LOGGER).info("The port is \t \t " + sdkConfigCredentialProvider.getSdkConfigCredential().getPort());
            Logger.getLogger(LOGGER).info("The host is \t \t " + sdkConfigCredentialProvider.getSdkConfigCredential().getHost());
            Logger.getLogger(LOGGER).info("The bucket name is \t \t " + sdkConfigCredentialProvider.getSdkConfigCredential().getBucketName());

        }
    }
}
