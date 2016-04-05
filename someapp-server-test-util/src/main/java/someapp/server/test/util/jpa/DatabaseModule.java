package someapp.server.test.util.jpa;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class DatabaseModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("myPU"));
        install(new JpaInitializerModule());
    }
}
