package lotto.controller;

import lotto.domain.AnswerLotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.service.LottoService;
import lotto.util.Parser;
import lotto.util.RandomLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Money userMoney = getMoney();
        int boughtTickets = userMoney.getTicket();

        Lottos boughtLottos = Lottos.generateLottos(new RandomLottoNumbersGenerator(), boughtTickets);
        printBuyStatus(boughtTickets, boughtLottos);

        AnswerLotto answerLotto = getAnswerLotto();
        PrizeResult prizeResult = boughtLottos.checkWinningResults(answerLotto.getAnswerNumbersDto());
        lottoService.sendPrizeMoney(userMoney, prizeResult);

        OutputView.printPrizeResult(prizeResult.getPrizeResult());
        OutputView.printRateOfReturn();
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

    private AnswerLotto getAnswerLotto() {
        while (true) {
            try {
                String answerLottoNumbers = InputView.getAnswerLottoNumbers();
                String answerBonusNumber = InputView.getBonusNumber();
                return Parser.parseAnswerLotto(answerLottoNumbers, answerBonusNumber);
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
