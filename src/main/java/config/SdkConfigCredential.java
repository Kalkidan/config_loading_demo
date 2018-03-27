package config;

/**
 * This will be just a contract to hold all
 * the credential file we need for the sdk
 */
public interface SdkConfigCredential {

    /***********************************************
     * Please add here for for more functionality
     ***********************************************/
    //
    String getHost();
    //
    String getBucketName();
    //
    String getPort();
}
