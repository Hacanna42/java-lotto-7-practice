package lotto.domain;

import java.util.List;
import lotto.dto.LottoNumbersDto;
import lotto.message.ErrorMessage;
import lotto.util.LottoNumbersGenerator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    public static Lotto generateLotto(LottoNumbersGenerator generator) {
        return new Lotto(generator.generate());
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getCorrectNumbersCount(List<Integer> answerNumbers) {
        return (int) answerNumbers.stream()
                .filter(this::isContain)
                .count();
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
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        for (final int number : numbers) {
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }
}
