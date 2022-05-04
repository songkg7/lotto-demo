package com.demo.lotto;

import com.demo.lotto.domain.Money;
import com.demo.lotto.view.InputView;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        Long amount = inputView.requestPurchaseAmount();
        Money inputMoney = Money.of(amount);

    }

}
