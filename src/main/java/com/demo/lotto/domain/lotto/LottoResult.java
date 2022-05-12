package com.demo.lotto.domain.lotto;

import java.util.List;
import lombok.Value;

@Value
public class LottoResult {

    LottoTicket lottoTicket;
    WinningNumbers winningNumbers;

    public static LottoResult of(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        return new LottoResult(lottoTicket, winningNumbers);
    }

    public Tear compareWinningNumber() {
        List<LottoNumbers> lottoNumbersGroup = lottoTicket.getLottoNumbersGroup();
        LottoNumbers numbers = winningNumbers.getNumbers();



        return null;
    }

}
