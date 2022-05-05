package com.demo.lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Value;

@Value
public class LottoNumbers {

    public static final int COUNT = 6;

    List<LottoNumber> numbers;

    public static LottoNumbers of(List<Integer> numbers) {
        List<LottoNumber> collect = numbers.stream()
                .map(LottoNumber::of)
                .filter(LottoNumber::validNumber)
                .collect(Collectors.toList());
        return new LottoNumbers(collect);
    }

}
