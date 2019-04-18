package com.bbd.modisa.soap;


import com.bbd.modisa.model.AccountDto;
import com.bbd.modisa.model.TransactionDto;
import com.bbd.modisa.model.UserDto;
import com.bbd.modisa.service.AccountService;
import com.bbd.modisa.service.BankingService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
@Stateless
public class BankSoap {
    @EJB
    private BankingService bankingService;

    @EJB
    private AccountService accountService;

    @WebMethod(operationName = "addUser")
    public UserDto addUser(UserDto userDto) {
        return bankingService.createUser(userDto);
    }

    @WebMethod(operationName = "newAccount")
    public AccountDto newAccount(AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }

    //deposit
    @WebMethod(operationName = "cashDeposit")
    public Double cashDeposit(@WebParam(name = "amount") Double amount, @WebParam(name = "accID") Integer accId){
        return accountService.deposit(amount, accId);
    }

    //withdrawal
    @WebMethod()
    public Double cashWithdrawal(@WebParam(name = "amount") Double amount, @WebParam(name = "accountId") Integer accountId){
        return accountService.withdraw(amount, accountId);
    }

    //getStatement
    @WebMethod(operationName = "printStatement")
    public TransactionDto getStatement(@WebParam(name = "userId") Integer userId){
        return accountService.getTransactions(userId);
    }
}
