package org.example.models;

import java.math.BigDecimal;
import java.util.UUID;
import java.time.Instant;

public class Transaction {
    UUID id;
    Instant timestamp;
    Account account;
    enum Type {DEPOSIT, WITHDRAW, TRANSFERIN, TRANSFEROUT};
    Type type;
    BigDecimal amount;

    public Transaction(UUID id, Instant timestamp, Type type, BigDecimal amount, Account account) {
        this.id = UUID.randomUUID();
        this.timestamp = Instant.now();
        this.type = type;
        this.amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.account=account;
    }

    UUID getId() {
        return id;
    }
    Instant getTimestamp() {
        return timestamp;
    }
    Account getAccount() {
        return account;
    }
    Type getType() {
        return type;
    }
    BigDecimal getAmount() {
        return amount;
    }
    void setAmount(BigDecimal newAmount) {
        this.amount=newAmount;
    }
    void setType(Type newType) {
        this.type=newType;
    }
    void setAccount(Account newAccount){
        this.account=newAccount;
    }
    void setTimestamp(Instant newTimestamp){
        this.timestamp=newTimestamp;
    }





}
