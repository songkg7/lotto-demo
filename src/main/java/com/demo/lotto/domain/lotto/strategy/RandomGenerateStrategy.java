package com.demo.lotto.domain.lotto.strategy;

import static java.util.stream.Collectors.*;

import com.demo.lotto.domain.lotto.LottoNumber;
import com.demo.lotto.domain.lotto.LottoNumbers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RandomGenerateStrategy implements LottoGenerateStrategy {

    private final int ticketCount;

    @Override
    public List<LottoNumbers> generate() {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> generateLottoNumbers())
                .collect(toList());
    }

    private LottoNumbers generateLottoNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < LottoNumbers.COUNT) {
            randomNumbers.add(random());
        }
        return LottoNumbers.of(new ArrayList<>(randomNumbers));
    }

    private int random() {
        return (int) (Math.random() * LottoNumber.MAX) + LottoNumber.MIN;
    }
}
