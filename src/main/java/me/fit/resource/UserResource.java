package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.User;
import me.fit.repository.UserRepository;

import java.util.List;

@Path("/user/")
public class UserResource {

    @Inject
    UserRepository userRepository;

    @Path("/addUser/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User s) {
        User user = userRepository.addUser(s);
        return Response.ok().build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllUsers")
    public Response getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        return Response.ok().entity(users).build();
    }


}
