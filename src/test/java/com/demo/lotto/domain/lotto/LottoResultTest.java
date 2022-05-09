package com.demo.lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import com.demo.lotto.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("입력된 번호가 당첨번호와 얼마나 비슷한지를 계산")
    void compareWinningNumber() {
        String inputNumber = "1 2 3 4 5 6";
        InputView inputView = createInputView(inputNumber);
        List<Integer> numbers = inputView.requestLottoNumber();

        LottoNumbers inputNumbers = LottoNumbers.of(numbers);

        LottoTicket lottoTicket = LottoTicket.of(List.of(inputNumbers));

        LottoResult firstResult = LottoResult.of(lottoTicket, numbers);
        Tear tear = firstResult.compareWinningNumber();
    }

    public InputView createInputView(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        return new InputView(new Scanner(inputStream));
    }
}