package com.programmingwith.mati;

public interface BankAccountRepository {

  BankAccount findById(int id);

  BankAccount save(BankAccount bankAccount);

  BankAccount update(BankAccount bankAccount);
}
