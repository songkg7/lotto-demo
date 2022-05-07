package com.demo.lotto.domain.lotto;

import java.util.List;
import lombok.Value;

@Value
public class LottoResult {

    LottoTicket lottoTicket;
    List<Integer> winningNumbers;

    public static LottoResult of(LottoTicket lottoTicket, List<Integer> winningNumbers) {
        return new LottoResult(lottoTicket, winningNumbers);
    }

    private void compareWinningNumber() {

    }

}
