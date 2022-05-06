package com.demo.lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputView {

    private final Scanner scanner;

    public List<List<Integer>> requestLottoNumber(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> requestLottoNumber())
                .collect(Collectors.toList());
    }

    public List<Integer> requestLottoNumber() {
        String input = scanner.nextLine();
        return Stream.of(input.split(" "))
                .map(Integer::valueOf)
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

    public int requestManualCount() {
        return inputNumber();
    }

    private int inputNumber() {
        return Integer.parseInt(inputString());
    }

    public String inputString() {
        return scanner.nextLine();
    }

    public Long requestLong() {
        return Long.parseLong(inputString());
    }
}
