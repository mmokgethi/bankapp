package com.bbd.modisa.service;

import com.bbd.modisa.data.entities.Transaction;
import com.bbd.modisa.data.entities.Transactions;
import com.bbd.modisa.model.Response;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        response.setMessage(tran.getAmount() + "Deposited Successful");
        return response;
    }

    @POST
    @Path("/{id}/withdraw")
    public Response makeWithdrawal(Transactions tran){
        trans.put((tran.getTranId()), tran);
        response.setStatus(true);
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
}
