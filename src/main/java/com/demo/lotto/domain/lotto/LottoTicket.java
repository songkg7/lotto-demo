package com.demo.lotto.domain.lotto;

import com.demo.lotto.domain.Money;
import com.demo.lotto.domain.lotto.strategy.LottoGenerateStrategy;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Value;

@Value
public class LottoTicket {
    public static final Money PRICE = new Money(BigDecimal.valueOf(1000));

    List<LottoNumbers> lottoNumbersGroup;

    public static LottoTicket of(List<LottoNumbers> lottoNumbersGroup) {
        return new LottoTicket(lottoNumbersGroup);
    }

    public static LottoTicket from(LottoGenerateStrategy... lottoGenerateStrategies) {
        List<LottoNumbers> collect = Stream.of(lottoGenerateStrategies)
                .map(LottoGenerateStrategy::generate)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new LottoTicket(collect);
    }

}
