package com.demo.lotto.domain.lotto.strategy;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.demo.lotto.domain.lotto.LottoNumbers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGenerateStrategyTest {

    @Test
    @DisplayName("1부터 45 사이의 중복되지 않는 6개의 랜덤 숫자가 생성된다.")
    void generate() {
        int ticketCount = 1;
        RandomGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy(ticketCount);
        List<LottoNumbers> lottoNumbersGroup = randomGenerateStrategy.generate();

        assertThat(lottoNumbersGroup).hasSize(ticketCount);
        List<Integer> numbers = lottoNumbersGroup.get(0).getNumbers();
        Set<Integer> set = new HashSet<>(numbers);
        assertThat(set).hasSize(6);
    }
}