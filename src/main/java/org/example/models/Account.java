package org.example.models;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Account {
    String accountId;
    UUID ownerUserId;
    boolean active;
    Instant createdAt;
    BigDecimal balance;


    public Account(String accountId, UUID ownerUserId, boolean active, Instant createdAt, BigDecimal balance) {
        this.accountId=accountId;
        this.ownerUserId = ownerUserId;
        this.active = true;
        this.createdAt = Instant.now();
        this.balance = balance;

    }
    public String getAccountId() {
        return accountId;
    }
    public UUID getOwnerUserId() {
        return ownerUserId;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public boolean isActive() {
        return active;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

}
