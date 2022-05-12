package com.demo.lotto.domain.lotto;

import java.util.Objects;
import lombok.Value;

@Value
public class LottoNumber {

    public static final int MAX = 45;
    public static final int MIN = 1;

    int number;

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public boolean validNumber() {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또 번호는 1보다 크고 45보다 작아야 합니다.");
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
