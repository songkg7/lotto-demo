package com.demo.lotto.domain.lotto;

import java.util.List;
import lombok.Value;

@Value
public class WinningNumbers {

    LottoNumbers numbers;
    LottoNumber bonusBall;

    public static WinningNumbers of(LottoNumbers numbers, LottoNumber bonusBall) {
        return new WinningNumbers(numbers, bonusBall);
    }
}
