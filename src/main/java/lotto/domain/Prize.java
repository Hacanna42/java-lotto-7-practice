package lotto.domain;

import java.util.Arrays;

public enum Prize {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);


    private final int requireCount;
    private final boolean requireBonusNumber;
    private final long prizeMoney;

    Prize(int requireCount, boolean requireBonusNumber, long prizeMoney) {
        this.requireCount = requireCount;
        this.requireBonusNumber = requireBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getRequireCount() {
        return requireCount;
    }

    public boolean isRequireBonusNumber() {
        return requireBonusNumber;
    }

    public static Prize getPrize(int correctNumbersCount, boolean isBonusNumberCorrected) {
        return Arrays.stream(values())
                .filter(prize -> (prize.requireCount == correctNumbersCount && !prize.requireBonusNumber) || (
                        prize.requireCount == correctNumbersCount && isBonusNumberCorrected))
                .findFirst()
                .orElse(Prize.NONE);
    }
}
