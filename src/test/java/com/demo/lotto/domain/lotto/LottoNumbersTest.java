package com.demo.lotto.domain.lotto;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    @DisplayName("몇 개의 로또 번호가 일치하는지 검사한다.")
    void hitCount() {
        List<Integer> integers = IntStream.of(1, 2, 3, 4, 5, 6).boxed().collect(toList());
        LottoNumbers lottoNumbers = LottoNumbers.of(integers);

        List<Integer> winningIntegers = IntStream.of(1, 2, 3, 7, 8, 9).boxed().collect(toList());
        LottoNumbers winningNumbers = LottoNumbers.of(winningIntegers);

        int hitCount = lottoNumbers.hitCount(winningNumbers);

        assertThat(hitCount).isEqualTo(3);
    }
}