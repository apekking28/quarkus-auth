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
        return Response.ok(userService.listAllUsers()).build();
    }

    @POST
    public Response addUser(UserRequestDTO request) {
        return Response.status(Response.Status.CREATED).entity(userService.addUser(request)).build();
    }

    @PUT
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") Long userId,UserRequestDTO request) {
        return Response.ok(userService.updateUser(userId,request)).build();
    }

    @DELETE
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") Long userId) {
        return Response.ok(userService.deleteUser(userId)).build();
    }

}
