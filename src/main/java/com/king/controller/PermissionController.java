package com.king.controller;

import com.king.dto.request.PermissionRequestDTO;
import com.king.service.PermissionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/permissions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PermissionController {

    @Inject
    PermissionService permissionService;

    @POST
    public Response addRole(PermissionRequestDTO request) {
        try {
            var response = permissionService.addPermission(request);
            return Response.status(Response.Status.CREATED).entity(response).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
}
