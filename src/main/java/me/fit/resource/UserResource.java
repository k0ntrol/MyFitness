package me.fit.resource;

import me.fit.model.client.Exercise_Muscle;
import me.fit.model.client.HolidayResponse;
import me.fit.model.client.TimeResponse;
import me.fit.restclient.HolidayClient;
import me.fit.restclient.TimeClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.User;
import me.fit.repository.UserRepository;
import jakarta.ws.rs.QueryParam;
import me.fit.exception.UserException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/user/")
public class UserResource {

//    @ConfigProperty(name = "greeting.message")
//    String message;

    @Inject
    UserRepository userRepository;

    @RestClient
    private TimeClient timeClient;



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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUsersByName")
    public Response getUsersByName(@QueryParam(value = "name") String name) {
        List<User> users;
        try {
            users = userRepository.getAllUsersByName(name);
        }catch(UserException e) {
            return Response.ok().entity(e.getMessage()).build();
        }

        return Response.ok().entity(users).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getTime")
    public Response getTime(@QueryParam(value = "timeZone") String timeZone) {

        TimeResponse time = timeClient.getTime("Europe/Amsterdam");

        return  Response.ok().entity(time).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createExerciseMuscle")
    public Response createExerciseMuscle(Exercise_Muscle ex_muscle) {
        Exercise_Muscle exerciseMuscle = userRepository.createExerciseMuscle(ex_muscle);

        return Response.ok().entity(exerciseMuscle).build();
    }



}
