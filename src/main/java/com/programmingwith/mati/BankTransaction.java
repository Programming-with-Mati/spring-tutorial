package com.programmingwith.mati;

import java.math.BigDecimal;

public record BankTransaction(
        int accountId,
        BigDecimal amount
) {
}
