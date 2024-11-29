package lotto.domain;

public class AnswerLotto {
    private final Lotto answerLotto;
    private final int bonusNumber;

    public AnswerLotto(Lotto answerLotto, int bonusNumber) {
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }
}
