package com.demo.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 40, 41, 42, 43, 44, 45 })
    @DisplayName("1 에서 45 까지의 숫자는 lotto 번호를 정상적으로 생성할 수 있다.")
    void validNumber(int number) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        boolean b = lottoNumber.validNumber();

        assertThat(lottoNumber).isNotNull();
        assertThat(b).isTrue();
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