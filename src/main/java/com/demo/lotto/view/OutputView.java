package com.demo.lotto.view;

import com.demo.lotto.domain.lotto.LottoTicket;

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

    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket);
    }

    public void requestManualCount() {
        System.out.println("수동으로 구매할 로또 개수를 입력해주세요.");
    }

    public void requestManualNumber() {
        System.out.println("로또 번호를 입력해주세요.");
    }

    public void requestWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public void requestBonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
    }
}
