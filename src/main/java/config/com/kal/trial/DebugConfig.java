package config.com.kal.trial;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        //
        resp.getWriter().println(DefaultConfiguration.HOST);
        //
        resp.getWriter().println(DefaultConfiguration.PORT);
        //
        resp.getWriter().println(DefaultConfiguration.BUCKET_NAME);
    }


    //
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
