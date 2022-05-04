package com.demo.lotto;

import com.demo.lotto.domain.Money;
import com.demo.lotto.view.InputView;
import com.demo.lotto.view.OutputView;
import java.util.Scanner;

public class LottoApp {

    private final InputView inputView = new InputView(new Scanner(System.in));
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = InputView.requireValidInput(this::inputMoney, outputView::printMessage);

    }

    private Money inputMoney() {
        inputView.requestPurchaseAmount();
        String inputAmount = inputView.inputAmount();
        return Money.of(Long.parseLong(inputAmount));
    }

}
