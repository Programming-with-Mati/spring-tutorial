package com.programmingwith.mati;

import java.math.BigDecimal;

public class BankAccountService {

  private final BankAccountRepository bankAccountRepository;

  public BankAccountService(BankAccountRepository bankAccountRepository) {
    this.bankAccountRepository = bankAccountRepository;
  }

  public BankAccount createBankAccount(int id) {
    return bankAccountRepository.save(new BankAccount(id, BigDecimal.ZERO));
  }

  public BankAccount findById(int id) {
    return bankAccountRepository.findById(id);
  }

  public BankAccount deposit(int bankAccountId, BigDecimal amount) {
    var bankAccount = bankAccountRepository.findById(bankAccountId);
    return bankAccountRepository.update(bankAccount.deposit(amount));
  }

}
