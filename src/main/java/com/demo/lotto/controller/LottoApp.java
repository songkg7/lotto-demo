package com.demo.lotto.controller;

import com.demo.lotto.domain.Money;
import com.demo.lotto.domain.lotto.LottoCount;
import com.demo.lotto.domain.lotto.LottoResult;
import com.demo.lotto.domain.lotto.LottoTicket;
import com.demo.lotto.domain.lotto.strategy.ManualGenerateStrategy;
import com.demo.lotto.domain.lotto.strategy.RandomGenerateStrategy;
import com.demo.lotto.view.InputView;
import com.demo.lotto.view.OutputView;
import java.util.List;
import java.util.Scanner;

public class LottoApp {

    private final InputView inputView = new InputView(new Scanner(System.in));
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = InputView.requireValidInput(this::inputMoney, outputView::printMessage);
        LottoCount lottoCount = InputView.requireValidInput(() -> inputLottoCount(money), outputView::printMessage);

        LottoTicket lottoTicket = InputView.requireValidInput(() -> buyTicket(lottoCount), outputView::printMessage);
        outputView.printLottoTicket(lottoTicket);

        LottoResult lottoResult = InputView.requireValidInput(() -> reporting(lottoTicket), outputView::printMessage);

    }

    private Money inputMoney() {
        Long amount = inputPurchaseAmount();
        return Money.of(amount);
    }

    private Long inputPurchaseAmount() {
        outputView.requestPurchaseAmount();
        return inputView.requestLong();
    }

    private LottoCount inputLottoCount(Money money) {
        int manualCount = inputManualCount();
        return LottoCount.of(money, manualCount);
    }

    private int inputManualCount() {
        outputView.requestManualCount();
        return inputView.requestManualCount();
    }

    private LottoTicket buyTicket(LottoCount lottoCount) {
        List<List<Integer>> lottoNumbersGroup = inputManualLottoNumber(lottoCount.getManualCount());
        ManualGenerateStrategy manualGenerateStrategy = new ManualGenerateStrategy(lottoNumbersGroup);
        RandomGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy(lottoCount.getAutoCount());
        return LottoTicket.from(manualGenerateStrategy, randomGenerateStrategy);
    }

    private List<List<Integer>> inputManualLottoNumber(int manualCount) {
        outputView.requestManualNumber();
        return inputView.requestLottoNumber(manualCount);
    }

    private LottoResult reporting(LottoTicket lottoTicket) {
        List<Integer> winningNumber = inputWinningNumber();
        return LottoResult.of(lottoTicket, winningNumber);
    }

    private List<Integer> inputWinningNumber() {
        outputView.requestWinningNumber();
        return inputView.requestLottoNumber();
    }

}
