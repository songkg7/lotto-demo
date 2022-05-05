package com.demo.lotto.view;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void requestPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public void requestLottoStrategy() {
        System.out.println("자동으로 구매하시겠습니까? (y or n)");
    }

    public void requestLottoNumberMessage() {
        System.out.println("6개의 숫자를 입력해주세요. (공백으로 구분)");
    }

}
