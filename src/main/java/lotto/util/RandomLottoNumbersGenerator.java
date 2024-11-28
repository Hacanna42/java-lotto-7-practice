package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumbersGenerator implements LottoNumbersGenerator {
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private final int startInclusive;
    private final int endInclusive;

    public RandomLottoNumbersGenerator(int startInclusive, int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, LOTTO_NUMBERS_COUNT);
    }
}
