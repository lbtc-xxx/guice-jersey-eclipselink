package someapp.server.test.util.jpa;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;

public class JpaInitializerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(JpaInitializer.class).asEagerSingleton();
    }

    @Singleton
    private static class JpaInitializer {
        @Inject
        public JpaInitializer(final PersistService service) {
            service.start();
        }
    }
}
