package com.demo.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @TestFactory
    Stream<DynamicTest> validNumber() {
        List<Integer> numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        return numbers.stream()
                .map(number -> dynamicTest(number + "가 45 이하인지 검사한다.",
                        () -> {
                            LottoNumber lottoNumber = LottoNumber.of(number);
                            boolean b = lottoNumber.validNumber();
                            assertThat(b).isTrue();
                        }));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 46 })
    @DisplayName("범위 밖의 번호로는 로또 번호 생성을 할 수 없다.")
    void shouldNotValidNumber(int number) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThatThrownBy(lottoNumber::validNumber).isInstanceOf(IllegalArgumentException.class);

        assertThat(lottoNumber).isNotNull();
    }
}