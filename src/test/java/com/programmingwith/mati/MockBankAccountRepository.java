package com.programmingwith.mati;

import java.util.HashMap;
import java.util.Map;

public class MockBankAccountRepository implements BankAccountRepository {

  private final Map<Integer, BankAccount> accounts = new HashMap<>();
  @Override
  public BankAccount findById(int id) {
    return accounts.get(id);
  }

  @Override
  public BankAccount save(BankAccount bankAccount) {
    return accounts.put(bankAccount.id(), bankAccount);
  }

  @Override
  public BankAccount update(BankAccount bankAccount) {
    return accounts.put(bankAccount.id(), bankAccount);
  }
}
