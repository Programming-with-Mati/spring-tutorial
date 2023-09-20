package com.programmingwith.mati;

import java.math.BigDecimal;

public record BankAccount(
        int id,
        BigDecimal balance
) {

  public BankAccount deposit(BigDecimal amount) {
    return new BankAccount(id, balance.add(amount));
  }
}
