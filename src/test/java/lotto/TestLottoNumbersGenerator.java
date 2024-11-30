package lotto;

import java.util.List;
import lotto.util.LottoNumbersGenerator;

public class TestLottoNumbersGenerator implements LottoNumbersGenerator {
    private final List<Integer> willGenerateNumber;

    public TestLottoNumbersGenerator(List<Integer> willGenerateNumber) {
        this.willGenerateNumber = willGenerateNumber;
    }

    @Override
    public List<Integer> generate() {
        return willGenerateNumber;
    }
}
