package com.bbd.modisa.rest;
import com.bbd.modisa.data.entities.Transaction;
import com.bbd.modisa.model.AccountDto;
import com.bbd.modisa.model.UserDto;
import com.bbd.modisa.service.AccountService;
import com.bbd.modisa.service.BankingService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bank")
@Stateless
public class BankRest {
    @EJB
    private BankingService bankingService;


    @EJB
    private AccountService accountService;

    @POST
    @Path("/createUser")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto createUser(UserDto userDto) {
        return bankingService.createUser(userDto);
    }

    @POST
    @Path("/createAccount")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountDto createAccount(AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }

    //deposit
    @GET
    @Path("/deposit")
    @Produces(MediaType.APPLICATION_JSON)
    public Double depositCash(@QueryParam("amount") Double amount, @QueryParam("accID") Integer accId){
        return accountService.deposit(amount, accId);
    }

    //withdrawal
    @GET
    @Path("/withdrawal")
    @Produces(MediaType.APPLICATION_JSON)
        public Double withdrawCash(@QueryParam("amount") Double amount, @QueryParam("accountId") Integer accountId){
        return accountService.withdraw(amount, accountId);
    }

    //getBalance
    @GET
    @Path("/getBalance")
    @Produces(MediaType.APPLICATION_JSON)
    public void getBalance(Integer userId){
        //return (double thi);
    }

    //getStatement
    @GET
    @Path("/getStatement/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getStatement(@PathParam("userId") Integer userId){
        return accountService.getTransactions(userId);
    }
}
