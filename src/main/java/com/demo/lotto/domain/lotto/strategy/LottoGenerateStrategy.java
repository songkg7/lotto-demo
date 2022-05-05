package com.demo.lotto.domain.lotto.strategy;

import com.demo.lotto.domain.lotto.LottoNumbers;
import java.util.List;

public interface LottoGenerateStrategy {

    List<LottoNumbers> generate();

}
