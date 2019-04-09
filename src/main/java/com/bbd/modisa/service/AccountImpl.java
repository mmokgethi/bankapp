package com.bbd.modisa.service;

import com.bbd.modisa.data.entities.Accounts;
import com.bbd.modisa.model.Response;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;


@Path("/account")
@Stateless
@Produces(MediaType.APPLICATION_XML)
public class AccountImpl {
    public static Map<Integer, Accounts> accounts = new HashMap<>();

    @POST
    @Path("/createAccount")
    public Response createAccount(Accounts acc){
        Response response = new Response();

        accounts.put((acc.getAccId()), acc);
        response.setStatus(true);
        response.setMessage("Account created successfully");
        return response;
    }

    @GET
    @Path("/{id}/getDefaultAcc")
    public Accounts getDummyUser(@PathParam("id") int id) {
        Accounts acc = new Accounts();
        acc.setAccId(1);
        acc.setAccountType("Cheque");
        acc.setAvailableBal(0.00);
        acc.setUserId(1);
        return acc;
    }
}
