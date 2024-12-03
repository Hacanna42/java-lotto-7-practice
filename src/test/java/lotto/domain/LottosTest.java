package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import lotto.TestLottoNumbersGenerator;
import lotto.util.RandomLottoNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    private final List<Integer> testNumbers = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName(".generateLottos() 정적 팩토리 메서드 동작 테스트")
    @Test
    void generateLottos_정적_팩토리_메서드_테스트() {
        // when
        Lottos lottos = Lottos.generateLottos(new RandomLottoNumbersGenerator(), 5);

        // then
        Assertions.assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @DisplayName(".checkWinningResults() 메서드가 의도대로 동작하는지 테스트")
    @Test
    void checkWinningResults_메서드_테스트() {
        // given
        Lottos lottos = Lottos.generateLottos(new TestLottoNumbersGenerator(testNumbers), 2);
        Lotto lotto = Lotto.generateLotto(new TestLottoNumbersGenerator(testNumbers));
        AnswerLotto answerLotto = new AnswerLotto(lotto, 7);

        // when
        PrizeResult prizeResult = lottos.checkWinningResults(answerLotto.getAnswerNumbersDto());

        // then
        EnumMap<Prize, Integer> result = prizeResult.getPrizeResult();
        Assertions.assertThat(result.getOrDefault(Prize.FIRST, 0)).isEqualTo(2);
    }
}