package com.programmingwith.mati;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankAccountService {

  private final BankAccountRepository bankAccountRepository;

  @Autowired
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
