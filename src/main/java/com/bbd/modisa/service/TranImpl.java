package com.bbd.modisa.service;
import com.bbd.modisa.data.entities.Transactions;
import com.bbd.modisa.data.entities.Users;
import com.bbd.modisa.model.Response;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/transaction")
@Stateless
@Produces(MediaType.APPLICATION_XML)
public class TranImpl {
    private Map<Integer, Transactions> trans = new HashMap<>();
    private Response response = new Response();

    @POST
    @Path("/{id}/deposit")
    public Response makeDeposit(Transactions tran){
        trans.put((tran.getTranId()), tran);
        response.setStatus(true);
        trans.get(tran.getAmount() + tran.getAmount());
        response.setMessage(tran.getAmount() + "Deposited Successful");
        return response;
    }

    @POST
    @Path("/{id}/withdraw")
    public Response makeWithdrawal(Transactions tran){
        trans.put((tran.getTranId()), tran);
        response.setStatus(true);
        trans.get(tran.getAmount() - tran.getAmount());
        response.setMessage(tran.getAmount() + " withdrawn successfully");
        return response;
    }

    @GET
    @Path("/{id}/checkBalance")
    public Response checkBalance(Transactions tran){
        Response response = new Response();

        //

        return response;
    }

    @GET
    @Path("/{id}/getDefTran")
    public Transactions getDummyUser(@PathParam("id") int id) {
        Transactions tran = new Transactions();
        tran.setTranId(id);
        tran.setAmount(500.00);
        tran.setTranType("Deposit");
        return tran;
    }
}
