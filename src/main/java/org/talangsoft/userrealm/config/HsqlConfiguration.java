package org.talangsoft.userrealm.config;

import org.hsqldb.Server;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.talangsoft.rest.devtools.logging.Loggable;

@Configuration
public class HsqlConfiguration implements Loggable {

    /**
     * HSQL Server bean available for remote access.
     *
     * @return
     */
    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public Server hsqlServer() {
        try {
            logger().debug("Starting HSQL server");
            Server server = new Server();

            server.setDatabaseName(0, "sql-database");

            server.setTrace(false);
            return server;
        } catch (Exception e) {
            throw new ApplicationContextException("Failed to start HSQL server", e);
        }
    }
}

