package com.demo.lotto.view;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputView {

    private final Scanner scanner;

    public void requestPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public static <T> T requireValidInput(Supplier<T> input, Consumer<String> errorMessageConsumer) {
        try {
            return input.get();
        } catch (IllegalArgumentException e) {
            errorMessageConsumer.accept(e.getMessage());
            return requireValidInput(input, errorMessageConsumer);
        }
    }

    public String inputAmount() {
        return scanner.nextLine();
    }
}
