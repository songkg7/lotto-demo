package com.demo.lotto.domain.lotto;

import com.demo.lotto.domain.Money;
import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    public List<Lotto> buy(Money money) {
        int lottoCount = money.divide(Lotto.PRICE);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

}
