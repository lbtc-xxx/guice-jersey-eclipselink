package someapp.server.restapi;

import com.fasterxml.jackson.annotation.JsonValue;
import someapp.vo.MyValidationException;
import someapp.vo.UserId;
import someapp.vo.Username;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
public class UsersResource {

    @Inject
    private UserService userService;

    // curl http://localhost:8080/someapp/webapi/users/1
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(final @PathParam("id") UserId userId) throws MyValidationException {
        return Response.ok(userService.find(userId)).build();
    }

    // curl --data "name=Jane Doe" http://localhost:8080/someapp/webapi/users
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(final @FormParam("name") Username username) {
        final UserId userId = userService.save(username);
        return Response.ok(userId).build();
    }
}
