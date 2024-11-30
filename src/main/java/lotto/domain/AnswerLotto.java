package lotto.domain;

import lotto.dto.AnswerNumbersDto;
import lotto.message.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
        }
    }
}
