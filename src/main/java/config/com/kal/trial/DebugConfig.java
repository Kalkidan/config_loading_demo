package config.com.kal.trial;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

public class DebugConfig extends HttpServlet{

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
        //
        Properties properties = new Properties();
        //
        String propertyFileName = this.getServletContext().getInitParameter("debug");
        //
        properties.load(getClass().getClassLoader().getResourceAsStream(propertyFileName));
        //
        Object myProperty = properties.getProperty("firstName");
        //
        resp.getWriter().println("EmbeddedJetty Just Have fun");
        //
        resp.getWriter().println(myProperty);

    }


    //
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
