package com.demo.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.demo.lotto.domain.Money;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {

    @Test
    @DisplayName("입력된 금액에 맞게 로또를 구매한다.")
    void buy() {
        Money money = Money.of(10000);

        LottoSeller lottoSeller = new LottoSeller();
        List<Lotto> lottos = lottoSeller.buy(money);

        assertThat(lottos).hasSize(10);
    }
}