package com.demo.lotto.domain.lotto.strategy;

import com.demo.lotto.domain.lotto.LottoNumbers;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RandomGenerateStrategy implements LottoGenerateStrategy {

    private final int lottoCount;

    @Override
    public List<LottoNumbers> generate() {
        return null;
    }
}
