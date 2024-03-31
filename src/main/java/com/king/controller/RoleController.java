package com.king.controller;

import com.king.dto.request.RoleRequestDTO;
import com.king.service.RoleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoleController {

    @Inject
    RoleService roleService;

    @GET
    public Response getAllRoles() {
        try {
            var response = roleService.getAllRoles();
            return Response.ok(response).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

    @POST
    public Response addRole(RoleRequestDTO request) {
        try {
            var response = roleService.addRole(request);
            return Response.ok(response).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{roleId}")
    public Response updateRole(@PathParam("roleId") String roleId, RoleRequestDTO request) {
        try {
            var response = roleService.updateRole(roleId, request);
            return Response.ok(response).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{roleId}")
    public Response deleteUser(@PathParam("roleId") String userId) {
        try {
            var response = roleService.deleteRole(userId);
            return Response.ok(response).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
}
