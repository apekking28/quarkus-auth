package com.king.controller;

import com.king.dto.request.RoleRequestDTO;
import com.king.service.RoleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoleController {

    @Inject
    RoleService roleService;

    @POST
    public Response addRole(RoleRequestDTO request) {
        return Response.status(Response.Status.CREATED).entity(roleService.addRole(request)).build();
    }
}
