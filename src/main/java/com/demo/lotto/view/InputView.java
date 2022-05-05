package com.demo.lotto.view;

import com.demo.lotto.domain.lotto.LottoNumbers;
import com.demo.lotto.domain.lotto.strategy.RandomGenerateStrategy;
import com.demo.lotto.domain.lotto.strategy.LottoGenerateStrategy;
import com.demo.lotto.domain.lotto.strategy.SelfGenerateStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputView {

    private final Scanner scanner;

    public void requestPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public LottoGenerateStrategy requestAutoLotto() {
        System.out.println("자동으로 구매하시겠습니까? (y or n)");
        String input = scanner.nextLine();
        if (input.toUpperCase(Locale.ROOT).equals("Y")) {
            return new RandomGenerateStrategy();
        }
        if (input.toUpperCase(Locale.ROOT).equals("N")) {
            return new SelfGenerateStrategy();
        }
        throw new IllegalArgumentException("y 또는 n 으로 입력해주세요.");
    }

    public List<LottoNumbers> requestLottoNumbers(int count) {
        System.out.println("6개의 숫자를 입력해주세요. (공백으로 구분)");
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(requestLottoNumber());
        }
        return lottoNumbers;
    }

    public LottoNumbers requestLottoNumber() {
        String input = scanner.nextLine();
        List<Integer> collect = Arrays.stream(input.split(" ")).map(Integer::valueOf)
                .collect(Collectors.toList());
        return LottoNumbers.of(collect);
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
