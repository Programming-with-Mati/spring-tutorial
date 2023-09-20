package com.programmingwith.mati;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountServiceTest {

  private MockBankAccountRepository bankAccountRepository;
  private BankAccountService bankAccountService;

  @BeforeEach
  void setup() {
    bankAccountRepository = new MockBankAccountRepository();
    bankAccountService = new BankAccountService(bankAccountRepository);
  }
  @Test
  void testBankAccountDeposit() {
    bankAccountRepository.save(new BankAccount(1, BigDecimal.ZERO));

    bankAccountService.deposit(1, BigDecimal.TEN);
    bankAccountService.deposit(1, BigDecimal.TEN);

    var bankAccount = bankAccountRepository.findById(1);

    assertEquals(BigDecimal.valueOf(20), bankAccount.balance());
  }
}
