package lotto.domain;

import lotto.dto.AnswerNumbersDto;

public class AnswerLotto {
    private final Lotto answerLotto;
    private final int bonusNumber;

    public AnswerLotto(Lotto answerLotto, int bonusNumber) {
        validate(answerLotto, bonusNumber);
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    public AnswerNumbersDto getAnswerNumbersDto() {
        return new AnswerNumbersDto(answerLotto.getLottoNumbersDto().numbers(), bonusNumber);
    }

    private void validate(Lotto answerLotto, int bonusNumber) {
        if (answerLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] ...");
        }
    }
}
