package com.demo.lotto.view;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputView {

    private final Scanner scanner;

    public Long requestPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");

        String inputAmount = scanner.nextLine();
        return Long.parseLong(inputAmount);
    }

}
