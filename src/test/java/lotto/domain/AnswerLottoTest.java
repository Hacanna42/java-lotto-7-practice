package lotto.domain;

import lotto.util.RandomLottoNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AnswerLottoTest {
    @DisplayName("정답 로또 객체를 올바르게 생성할 수 있는지 테스트")
    @Test
    void 정답로또_객체_생성_테스트() {
        // when
        AnswerLotto answerLotto = new AnswerLotto(Lotto.generateLotto(new RandomLottoNumbersGenerator()), 1);

        // then
        Assertions.assertThat(answerLotto).isInstanceOf(AnswerLotto.class);
    }

    @DisplayName("보너스 번호 범위를 넘어섰을때의 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호_예외_테스트(int number) {
        // given
        Lotto lotto = Lotto.generateLotto(new RandomLottoNumbersGenerator());

        // when & then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new AnswerLotto(lotto, number));
    }
}