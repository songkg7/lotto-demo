package com.demo.lotto.controller;

import com.demo.lotto.domain.Money;
import com.demo.lotto.domain.lotto.LottoNumbers;
import com.demo.lotto.domain.lotto.LottoTicket;
import com.demo.lotto.domain.lotto.strategy.LottoGenerateStrategy;
import com.demo.lotto.view.InputView;
import com.demo.lotto.view.OutputView;
import java.util.List;
import java.util.Scanner;

public class LottoApp {

    private final InputView inputView = new InputView(new Scanner(System.in));
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = InputView.requireValidInput(this::inputMoney, outputView::printMessage);
        int lottoCount = money.divide(LottoTicket.PRICE);
        LottoTicket lottoTicket = InputView.requireValidInput(() -> this.buyTicket(lottoCount), outputView::printMessage);


    }

    private Money inputMoney() {
        outputView.requestPurchaseAmount();
        String inputAmount = inputView.inputAmount();
        return Money.of(Long.parseLong(inputAmount));
    }

    private LottoTicket buyTicket(int count) {
        outputView.requestLottoStrategy();
        LottoGenerateStrategy lottoGenerateStrategy = inputView.requestLottoStrategy(count);
        List<LottoNumbers> lottoNumbers = lottoGenerateStrategy.generate();
        return LottoTicket.of(lottoNumbers);
    }

    public LottoNumbers inputLottoNumbers() {
        List<Integer> integers = inputView.requestLottoNumber();
        return LottoNumbers.of(integers);
    }

}
