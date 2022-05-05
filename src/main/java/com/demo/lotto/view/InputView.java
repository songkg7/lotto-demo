package com.demo.lotto.view;

import com.demo.lotto.domain.Money;
import com.demo.lotto.domain.lotto.LottoNumbers;
import com.demo.lotto.domain.lotto.LottoTicket;
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
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputView {

    private final Scanner scanner;

    public void requestPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public LottoGenerateStrategy requestLottoStrategy(Money money) {
        System.out.println("자동으로 구매하시겠습니까? (y or n)");
        String input = scanner.nextLine();
        int lottoCount = money.divide(LottoTicket.PRICE);
        if (input.toUpperCase(Locale.ROOT).equals("Y")) {
            return new RandomGenerateStrategy(lottoCount);
        }
        if (input.toUpperCase(Locale.ROOT).equals("N")) {
            requestLottoNumberMessage();
            return new SelfGenerateStrategy(requestLottoNumber(lottoCount));
        }
        throw new IllegalArgumentException("y 또는 n 으로 입력해주세요.");
    }

    public void requestLottoNumberMessage() {
        System.out.println("6개의 숫자를 입력해주세요. (공백으로 구분)");
    }

    public List<Integer> requestLottoNumber() {
        String input = scanner.nextLine();
        return Arrays.stream(input.split(" ")).map(Integer::valueOf)
                .collect(Collectors.toList());

    }

    public List<LottoNumbers> requestLottoNumber(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> LottoNumbers.of(requestLottoNumber()))
                .collect(Collectors.toList());
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
