package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int requireCount;
    private final boolean requireBonusNumber;
    private final int prizeMoney;

    Prize(int requireCount, boolean requireBonusNumber, int prizeMoney) {
        this.requireCount = requireCount;
        this.requireBonusNumber = requireBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static Prize getPrize(int correctNumbersCount, boolean isBonusNumberCorrected) {
        return Arrays.stream(values())
                .filter(prize -> (prize.requireCount == correctNumbersCount && !prize.requireBonusNumber) || (
                        prize.requireCount == correctNumbersCount && isBonusNumberCorrected))
                .findFirst()
                .orElse(Prize.NONE);
    }
}
