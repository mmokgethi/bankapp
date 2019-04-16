package com.bbd.modisa.mapper;

import com.bbd.modisa.data.entities.Transaction;
import com.bbd.modisa.model.TransactionDto;

public class TransactionMapper extends ModelMapper<TransactionDto, Transaction> {

    @Override
    public Transaction dtoToDb(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();

        transaction.setAccount_accId(transactionDto.getAccount_accId());
        transaction.setAccount_User_userId(transactionDto.getAccount_User_userId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setTranTypeCode(transactionDto.getTranType());

        return transaction;
    }

    @Override
    public TransactionDto dbToDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setAccount_accId(transaction.getAccount_accId());
        transactionDto.setAccount_User_userId(transaction.getAccount_User_userId());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setTranType(transaction.getTranType());

        return transactionDto;
    }
}
