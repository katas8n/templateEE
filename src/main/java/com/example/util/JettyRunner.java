package com.example.util;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.example.servlet.TestServlet;

public class JettyRunner {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        context.setResourceBase("src/main/resources");

        ServletHolder defaultServlet = new ServletHolder("default", new DefaultServlet());
        context.addServlet(defaultServlet, "/assets/*");

        ServletHolder servletHolder = new ServletHolder(new TestServlet());
        context.addServlet(servletHolder, "/");

        server.setHandler(context);

        server.start();
        server.join();
    }
}
