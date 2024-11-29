package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class Parser {
    public static Money parseMoney(String amount) {
        return Money.initFrom(Integer.parseInt(amount));
    }

    public static AnswerLotto parseAnswerLotto(String answerLottoNumbers, String answerBonusNumber) {
        List<Integer> lottoNumbers = Arrays.stream(answerLottoNumbers.split(",")).map(Integer::parseInt).toList();
        Lotto lotto = new Lotto(lottoNumbers);
        return new AnswerLotto(lotto, Integer.parseInt(answerBonusNumber));
    }
}
