package com.bbd.modisa.service;

import com.bbd.modisa.data.entities.Account;
import com.bbd.modisa.data.entities.Transaction;
import com.bbd.modisa.data.model.AccountDto;
import com.bbd.modisa.data.service.BankingDataService;

import javax.persistence.*;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private BankingDataService bankingDataService;

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
    private EntityManager entityManager = null;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = new Account();

        account.setUser_userId(accountDto.getUser_userId());
        account.setAvailBalance(accountDto.getAvailBalance());
        account.setAccType(accountDto.getAccType());

        bankingDataService.createAccount(account);
        return accountDto;
    }

    @Override
    public double deposit(double depositAmount, Integer accountId) {
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createNativeQuery("UPDATE Account SET availBalance = availBalance" +
                "+ ? WHERE accId = ?");

        query.setParameter(1, depositAmount);
        query.setParameter(2, accountId);
        query.executeUpdate();
        entityManager.close();

        return depositAmount;
    }

    @Override
    public double withdraw(double withdrawalAmount, Integer accountId) {
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createNativeQuery("UPDATE Account SET availBalance = availBalance" +
                " - ? WHERE accId = ?");

        query.setParameter(1, withdrawalAmount);
        query.setParameter(2, accountId);
        query.executeUpdate();
        entityManager.close();
        return  withdrawalAmount;
    }

    @Override
    public List<Transaction> getTransactions(Integer userId){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();

        entityManager.getTransaction().begin();

        return (List<Transaction>) entityManager.find(Transaction.class, userId);
    }

    @Override
    public double getBalance() {
        return 0;
    }
}
