package someapp.server.common;

import com.google.inject.persist.Transactional;
import someapp.server.entity.User;
import someapp.vo.UserId;
import someapp.vo.Username;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserService {

    private final EntityManager em;

    @Inject
    public UserService(final EntityManager em) {
        this.em = em;
    }

    @Transactional
    public UserId save(final Username username) {
        final User user = new User();
        user.setUsername(username);
        em.persist(user);
        em.flush();
        return user.getId();
    }

    public User find(final UserId userId) {
        return em.find(User.class, userId.getValue());
    }
}
