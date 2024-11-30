package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class Parser {
    public static Money parseMoney(String amount) {
        try {
            return Money.initFrom(Integer.parseInt(amount));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 돈의 입력이 올바르지 않습니다. 숫자만 입력해주세요.");
        }
    }

    public static AnswerLotto parseAnswerLotto(String answerLottoNumbers, String answerBonusNumber) {
        try {
            List<Integer> lottoNumbers = Arrays.stream(answerLottoNumbers.split(",")).map(Integer::parseInt).toList();
            Lotto lotto = new Lotto(lottoNumbers);
            return new AnswerLotto(lotto, Integer.parseInt(answerBonusNumber));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 입력이 올바르지 않습니다. 숫자와 반점(,)만 입력해주세요.");
        }
    }
}
