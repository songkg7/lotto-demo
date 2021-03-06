package com.demo.lotto.domain.lotto.strategy;

import com.demo.lotto.domain.lotto.LottoNumbers;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManualGenerateStrategy implements LottoGenerateStrategy {

    private final List<List<Integer>> lottoNumbersGroup;

    @Override
    public List<LottoNumbers> generate() {
        return lottoNumbersGroup.stream()
                .map(LottoNumbers::of)
                .filter(LottoNumbers::isUnique)
                .collect(Collectors.toList());
    }
}
