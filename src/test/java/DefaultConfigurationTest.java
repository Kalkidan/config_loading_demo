import config.com.kal.trial.DefaultConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.spy;


/**
 *
 * Tests {@link config.com.kal.trial.DefaultConfiguration}
 */

public class DefaultConfigurationTest {

    Configurations configurations = spy(Configurations.class);
    Configuration configuration;

    @Before public void setup() throws IOException, ConfigurationException {
        configuration = configurations.properties(spy(new File("etc/verve/sdkconfig/" + "qa.yaml")));
    }

    @Test
    public void initial_config_test(){
        assertEquals(DefaultConfiguration.HOST,  configuration.getProperty("host"));
        assertEquals(DefaultConfiguration.PORT,  configuration.getProperty("port"));
        assertEquals(DefaultConfiguration.BUCKET_NAME,   configuration.getProperty("bucketName"));
    }
}
