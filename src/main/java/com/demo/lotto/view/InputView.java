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

    public LottoGenerateStrategy requestLottoStrategy(int lottoCount) {
        String input = scanner.nextLine();
        if (input.toUpperCase(Locale.ROOT).equals("Y")) {
            return new RandomGenerateStrategy(lottoCount);
        }
        if (input.toUpperCase(Locale.ROOT).equals("N")) {
            System.out.println("6개의 숫자를 입력해주세요 (공백으로 구분)");
            return new SelfGenerateStrategy(requestLottoNumber(lottoCount));
        }
        throw new IllegalArgumentException("y 또는 n 으로 입력해주세요.");
    }

    public List<Integer> requestLottoNumber() {
        String input = scanner.nextLine();
        return Arrays.stream(input.split(" ")).map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> requestLottoNumber(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> requestLottoNumber())
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
