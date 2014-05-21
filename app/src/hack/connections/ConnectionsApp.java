package hack.connections;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ConnectionsApp extends Application<ConnectionsConfiguration> {

    public static void main(String[] args) throws Exception {
        new ConnectionsApp().run(args);
    }

    @Override
    public String getName() {
        return "connections-app";
    }

    @Override
    public void initialize(Bootstrap<ConnectionsConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ConnectionsConfiguration conf, Environment env) {
        env.healthChecks().register("template", new AppHealthCheck(conf.getTemplate()));
        env.jersey().register(new ConnectionsResource(conf.getTemplate(), conf.getDefaultName() ));
    }

}