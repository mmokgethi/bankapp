package com.bbd.modisa.service;

import com.bbd.modisa.data.entities.Users;
import com.bbd.modisa.model.Response;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/user")
@Stateless
@Produces(MediaType.APPLICATION_XML)
public class UserImpl {
    public static Map<Integer, Users> users = new HashMap<>();
    @POST
    @Path("/createUsers")
    public Response createUser(Users u){
        Response response = new Response();

        if (users.get(u.getId()) != null){
            response.setStatus(false);
            response.setMessage("User already exists");
            return response;
        }

        users.put(u.getId(), u);
        response.setStatus(true);
        response.setMessage("User created successfully");
        return response;
    }

    @GET
    @Path("/{id}/getDummy")
    public Users getDummyUser(@PathParam("id") int id) {
        Users u = new Users();
        u.setfName("Modisa");
        u.setlName("Mokgethi");
        u.setId(id);
        return u;
    }
}
