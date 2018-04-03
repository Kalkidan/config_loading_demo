package config.com.kal.trial;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;

public class Main {


    public static final String LOGGER = Main.class.getSimpleName();
    //Example to demo
    public static void main(String[] args) throws Exception {
        Server server = new Server(8060);
        server.setHandler(new DefaultHandler());
        server.start();
        server.join();
    }
}
