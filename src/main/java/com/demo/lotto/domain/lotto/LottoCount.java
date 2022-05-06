package com.demo.lotto.domain.lotto;

import com.demo.lotto.domain.Money;
import lombok.Value;

@Value
public class LottoCount {

    int manualCount;
    int autoCount;

    public static LottoCount of(Money money, int manualCount) {
        int totalCount = money.divide(LottoTicket.PRICE);
        return new LottoCount(manualCount, totalCount - manualCount);
    }

}
