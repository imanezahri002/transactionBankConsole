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

}
