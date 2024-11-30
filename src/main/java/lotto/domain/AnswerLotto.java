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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
