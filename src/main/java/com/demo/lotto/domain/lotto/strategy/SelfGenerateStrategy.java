package com.demo.lotto.domain.lotto.strategy;

import com.demo.lotto.domain.lotto.LottoNumbers;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SelfGenerateStrategy implements LottoGenerateStrategy {

    private final List<LottoNumbers> lottoNumbersGroup;

    @Override
    public List<LottoNumbers> generate() {
        return lottoNumbersGroup;
    }
}
