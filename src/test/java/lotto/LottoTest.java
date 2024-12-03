package lotto;

import lotto.domain.Lotto;
import lotto.util.RandomLottoNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private final List<Integer> testNumbers = List.of(1, 2, 3, 4, 5, 6);

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 객체를 올바르게 생성할 수 있다.")
    @Test
    void 로또_객체_생성_테스트() {
        // when
        Lotto lotto = Lotto.generateLotto(new RandomLottoNumbersGenerator());

        // then
        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName(".isContain() 메서드가 의도대로 동작하는지 확인한다.")
    @Test
    void isContain_메서드_테스트() {
        // given
        Lotto lotto = Lotto.generateLotto(new TestLottoNumbersGenerator(testNumbers));

        // when
        boolean shouldTrueResult = lotto.isContain(1);
        boolean shouldFalseResult = lotto.isContain(7);

        // then
        Assertions.assertThat(shouldTrueResult).isTrue();
        Assertions.assertThat(shouldFalseResult).isFalse();
    }

    @DisplayName(".getCorrectNumbersCount() 메서드가 의도대로 동작하는지 확인한다.")
    @Test
    void getCorrectNumbersCount_메서드_테스트() {
        // given
        Lotto lotto = Lotto.generateLotto(new TestLottoNumbersGenerator(testNumbers));
        Lotto answerLotto = Lotto.generateLotto(new TestLottoNumbersGenerator(testNumbers));

        // when
        int result = lotto.getCorrectNumbersCount(answerLotto.getLottoNumbersDto().numbers());

        // then
        Assertions.assertThat(result).isEqualTo(6);
    }
}
