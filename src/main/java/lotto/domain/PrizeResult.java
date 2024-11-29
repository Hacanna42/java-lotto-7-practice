package lotto.domain;

import java.util.EnumMap;

public class PrizeResult {
    private final EnumMap<Prize, Integer> prizeResult;

    public PrizeResult() {
        prizeResult = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeResult.put(prize, 0);
        }
    }

    public void winPrize(Prize prize) {
        prizeResult.compute(prize, (k, prizeCount) -> prizeCount + 1);
    }

    public EnumMap<Prize, Integer> getPrizeResult() {
        return prizeResult;
    }
}
