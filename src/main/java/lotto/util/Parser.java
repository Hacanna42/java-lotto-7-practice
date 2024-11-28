package lotto.util;

import lotto.domain.Money;

public class Parser {
    public static Money parseMoney(String amount) {
        return Money.initFrom(Integer.parseInt(amount));
    }
}
