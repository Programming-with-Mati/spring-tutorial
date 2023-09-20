package com.programmingwith.mati;

import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    var bankAccountService = new BankAccountService(new JdbcBankAccountRepository());
    bankAccountService.deposit(1, BigDecimal.TEN);
    var bankAccount = bankAccountService.findById(1);
    System.out.println("The balance of account '%d' is: %s".formatted(bankAccount.id(), bankAccount.balance()));
  }
}
