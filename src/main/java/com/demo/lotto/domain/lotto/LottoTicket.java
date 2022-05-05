package com.demo.lotto.domain.lotto;

import com.demo.lotto.domain.Money;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Value;

@Value
public class LottoTicket {
    public static final Money PRICE = new Money(BigDecimal.valueOf(1000));

    List<LottoNumbers> lottoNumbersGroup;

    public static LottoTicket of(List<LottoNumbers> lottoNumbersGroup) {
        return new LottoTicket(lottoNumbersGroup);
    }

}
