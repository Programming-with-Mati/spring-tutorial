package com.programmingwith.mati;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/account")
public class BankAccountController {


  private final BankAccountService bankAccountService;

  @Autowired
  public BankAccountController(BankAccountService bankAccountService) {
    this.bankAccountService = bankAccountService;
  }

  @GetMapping("/{id}")
  public BankAccount getBankAccount(@PathVariable("id")int id) {
    return bankAccountService.findById(id);
  }

  @PutMapping("/deposit")
  public BankAccount deposit(@RequestBody BankTransaction bankTransaction) {
    return bankAccountService.deposit(bankTransaction.accountId(), bankTransaction.amount());
  }
}
