package someapp.server.test.fixture;

import com.google.inject.persist.Transactional;
import someapp.server.entity.User;
import someapp.vo.UserId;
import someapp.vo.Username;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserFixture {

    private final EntityManager em;

    @Inject
    public UserFixture(final EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void populate() {
        final User jane = new User();
        jane.setId(new UserId(1));
        jane.setUsername(new Username("jane doe"));
        em.persist(jane);

        final User john = new User();
        john.setId(new UserId(2));
        john.setUsername(new Username("john doe"));
        em.persist(john);
    }
}
