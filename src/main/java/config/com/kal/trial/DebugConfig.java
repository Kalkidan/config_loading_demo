package config.com.kal.trial;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DebugConfig extends HttpServlet{

    private static final String LOGGER = DebugConfig.class.getSimpleName();

    //
    @Override
    public void init() throws ServletException {
        super.init();
    }

    //
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    //
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);

        long apacheReadingStart = System.nanoTime();
        //
        Configurations configs = new Configurations();
        Configuration config = null;

        //
        try {
             config = configs.properties(new File("Couchbase.yml"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        config.getString("host");
        config.getString("port");
        config.getString("bucketName");
        String dateOfIssue = config.getString("dateOfIssue");
        //
        long apacheDifference = System.nanoTime() - apacheReadingStart;

        //
        if(config != null){}
        resp.getWriter().println("The time elasped fetching data is: \t"  + "\t is\t"
                + String.valueOf(apacheDifference/1000000000.0)+ "\t seconds \n" + dateOfIssue);

        //
        long nativeLoadingStart = System.nanoTime();

        //
        Properties properties = new Properties();
        //
        String propertyFileName = this.getServletContext().getInitParameter("debug");
        //
        properties.load(getClass().getClassLoader().getResourceAsStream(propertyFileName));
        //
        properties.getProperty("host");
        properties.getProperty("port");
        properties.getProperty("bucketName");
        String dateOfIssue1 = properties.getProperty("dateOfIssue");
        //
        long nativeLoadingDifference = System.nanoTime() - nativeLoadingStart;

        //
        //
        resp.getWriter().println("The time elasped fetching data is: \t" +
                "\t is\t" + String.valueOf(nativeLoadingDifference/1000000000.0)+"\t seconds \t" + dateOfIssue1);

    }


    //
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
