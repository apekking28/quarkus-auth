package com.king.controller;

import com.king.dto.request.UserRequestDTO;
import com.king.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @GET
    public Response getAllUsers() {
        try {
            var response = userService.listAllUsers();
            return Response.ok(response).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

    @POST
    public Response addUser(UserRequestDTO request) {
        try {
            var response = userService.addUser(request);
            return Response.ok(response).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") String userId, UserRequestDTO request) {
        try {
            var response = userService.updateUser(userId, request);
            return Response.ok(response).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") String userId) {
        try {
            var response = userService.deleteUser(userId);
            return Response.ok(response).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

}
