package org.motechproject.spike;

import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        tomcat.setPort(Integer.valueOf(webPort));

        final String contextPath = "/spike-tomcat";
        final String webappDirLocation = "src/main/webapp/";

        tomcat.addWebapp(contextPath, new File(webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
