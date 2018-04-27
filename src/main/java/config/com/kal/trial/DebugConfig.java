package config.com.kal.trial;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DebugConfig extends HttpServlet{

    private static final String LOGGER = DebugConfig.class.getSimpleName();
    private static final String COUCHBASE_PASSWORD = "COUCHBASE_PASSWORD";
    private static final String COUCHBASE_USERNAME = "COUCHBASE_USERNAME";
    private static final String COUCHBASE_PORT = "COUCHBASE_PORT";
    private static final String COUCHBASE_HOST = "COUCHBASE_HOST";

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
        //This is how we load the env file
        resp.getWriter().println(System.getenv(COUCHBASE_PASSWORD));
        resp.getWriter().println(System.getenv(COUCHBASE_USERNAME));
        resp.getWriter().println(System.getenv(COUCHBASE_PORT));
        resp.getWriter().println(System.getenv(COUCHBASE_HOST));

    }


    //
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
