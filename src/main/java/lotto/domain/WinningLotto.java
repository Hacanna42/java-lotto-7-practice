package lotto.domain;

public class WinningLotto {
    private final Lotto answerLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto answerLotto, int bonusNumber) {
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }
}
