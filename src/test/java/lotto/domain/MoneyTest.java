package lotto.domain;

import java.util.List;
import lotto.TestLottoNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    private final List<Integer> testNumbers = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("Money 객체 생성이 올바르게 되는지 확인")
    @Test
    void Money_객체_생성_테스트() {
        // when
        Money money = Money.initFrom(1000);

        // then
        Assertions.assertThat(money).isInstanceOf(Money.class);
    }

    @DisplayName("돈을 1,000원 단위로 입력하지 않았을때의 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2300, 40005, 700})
    void 돈_단위_예외_테스트(int amount) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Money.initFrom(amount));
    }

    @DisplayName(".getTicket() 메서드가 의도대로 동작하는지 테스트")
    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "2000, 2",
            "13000, 13"
    })
    void getTicket_메서드_테스트(int moneyAmount, int expectedTicketCount) {
        // given
        Money money = Money.initFrom(moneyAmount);

        // when
        int ticketCount = money.getTicket();

        // then
        Assertions.assertThat(ticketCount).isEqualTo(expectedTicketCount);
    }

    @DisplayName(".addMoneyByPrize() 메서드가 의도대로 동작하는지 테스트")
    @Test
    void addMoneyByPrize_메서드_테스트() {
        // given
        Money money = Money.initFrom(0);

        // when
        money.addMoneyByPrize(Prize.FIRST, 2);

        // then
        int ticketCount = money.getTicket();
        long expectedTicketCount = (Prize.FIRST.getPrizeMoney() * 2) / 1000;
        Assertions.assertThat(ticketCount).isEqualTo(expectedTicketCount);
    }

    @DisplayName(".getRateOfReturn() 메서드가 의도대로 동작하는지 테스트")
    @Test
    void getRateOfReturn_메서드_테스트() {
        // given
        Money money = Money.initFrom(1000);
        money.getTicket();
        money.addMoneyByPrize(Prize.FIFTH, 1);

        // when
        double result = money.getRateOfReturn();

        // then
        Assertions.assertThat(result).isEqualTo(500.0);
    }
}