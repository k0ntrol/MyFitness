package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.User;
import me.fit.repository.UserService;

public class UserResource {

    @Inject
    UserService userService;

    @Path("addUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User s) {
        User user = userService.addUser(s);
        return Response.ok().build();
    }
}
