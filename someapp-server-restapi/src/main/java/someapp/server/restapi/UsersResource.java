package someapp.server.restapi;

import someapp.server.common.UserService;
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
    public Response getUser(final @PathParam("id") UserId userId) {
        return Response.ok(userService.find(userId)).build();
    }

    // curl --data "name=Jane Doe" http://localhost:8080/someapp/webapi/users
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(final @FormParam("name") Username username) {
        return Response.ok(userService.save(username)).build();
    }
}
