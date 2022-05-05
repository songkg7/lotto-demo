package com.demo.lotto.domain.lotto;

import java.util.List;
import lombok.Value;

@Value
public class LottoNumbers {

    public static final int COUNT = 6;

    List<Integer> numbers;

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

}
