package lotto.domain;

import java.util.List;
import lotto.dto.LottoNumbersDto;
import lotto.util.LottoNumbersGenerator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    public static Lotto generateRandomLotto(LottoNumbersGenerator generator) {
        return new Lotto(generator.generate());
    }

    public LottoNumbersDto getLottoNumbersDto() {
        return new LottoNumbersDto(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        validateLottoNumbersRange(numbers);
    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        for (final int number : numbers) {
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
