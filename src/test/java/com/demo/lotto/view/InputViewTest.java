package com.demo.lotto.view;

import static org.assertj.core.api.Assertions.*;

import com.demo.lotto.domain.lotto.LottoNumbers;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private static final String INPUT_NEW_LINE = "\n";

    @Test
    void requestPurchaseAmount() {

    }

    @Test
    @DisplayName("공백으로 구분된 숫자를 받아서 LottoNumber 를 생성한다.")
    void requestLottoNumber() {
        String inputNumber = "1 2 3 4 5 6" + INPUT_NEW_LINE;
        InputView inputView = createInputView(inputNumber);

        LottoNumbers lottoNumbers = inputView.requestLottoNumber();

        assertThat(lottoNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    public InputView createInputView(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        return new InputView(new Scanner(inputStream));
    }
}