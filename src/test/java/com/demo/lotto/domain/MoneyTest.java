package com.demo.lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class MoneyTest {

    @Test
    @Disabled
    void create() {

    }

    @Test
    void divide() {
        Money won10000 = Money.of(10000);
        Money won1000 = Money.of(1000);

        int result = won10000.divide(won1000);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void divide_1() {
        Money won10000 = Money.of(10100);
        Money won1000 = Money.of(1000);

        int result = won10000.divide(won1000);

        assertThat(result).isEqualTo(10);
    }
}