package someapp.server.entity;

import someapp.vo.MyValidationException;
import someapp.vo.UserId;
import someapp.vo.Username;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "my_user")  // "User" is a reserved word
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;

    public UserId getId() {
        try {
            // store cached instance into a @Transient field instead if performance matters
            return new UserId(id);
        } catch (final MyValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public void setId(final UserId id) {
        this.id = id.getValue();
    }

    public Username getUsername() {
        try {
            return new Username(username);
        } catch (final MyValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUsername(final Username username) {
        this.username = username.getValue();
    }
}
