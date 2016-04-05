package someapp.server.common;

import org.jukito.UseModules;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import someapp.server.entity.User;
import someapp.server.test.fixture.UserFixture;
import someapp.server.test.util.jpa.DatabaseModule;
import someapp.server.test.util.jpa.JpaJukitoRunner;
import someapp.vo.UserId;
import someapp.vo.Username;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JpaJukitoRunner.class)
@UseModules(DatabaseModule.class)
public class UserServiceTest {

    @Inject
    private UserService sut;
    @Inject
    private UserFixture fixture;

    @Before
    public void setUp() throws Exception {
        fixture.populate();
    }

    @Test
    public void janeDoeShouldBeFound() throws Exception {
        final UserId userId = new UserId(1);

        final User actual = sut.find(userId);

        assertThat(actual.getId(), is(userId));
        assertThat(actual.getUsername(), is(new Username("jane doe")));
    }
}
