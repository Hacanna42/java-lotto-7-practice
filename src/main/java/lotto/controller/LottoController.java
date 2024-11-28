package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.util.Parser;
import lotto.util.RandomLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Money userMoney = getMoney();
        int boughtTickets = userMoney.getTicket();
        Lottos boughtLottos = Lottos.generateLottos(new RandomLottoNumbersGenerator(), boughtTickets);
        printBuyStatus(boughtTickets, boughtLottos);
    }

    private Money getMoney() {
        while (true) {
            try {
                return Parser.parseMoney(InputView.getPurchaseAmount());
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] ...");
            }
        }
    }

    private void printBuyStatus(int boughtTickets, Lottos boughtLottos) {
        OutputView.printBoughtAmount(boughtTickets);
        OutputView.printBoughtLottos(boughtLottos.getLottoNumbersDtos());
    }
}
