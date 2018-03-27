package config;

/**
 * A class where we extend contract to lower levels
 * to extend or use it in the initializaion
 */
public interface ConfigServicePropertyProvider {

    /**
     *
     * This fetches and provides any boot config file
     */
    ConfigServiceProperties getSdkConfigCredential();


    /**
     * If we intend to clean up for a server resource
     *
     * TODO:: Do clean up here, extend any contract
     */


}
