package com.demo.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
public class Money {

    BigDecimal amount;

    public static Money of(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public int divide(Money money) {
        BigDecimal divide = amount.divide(money.amount, RoundingMode.DOWN);
        return divide.intValue();
    }
}
