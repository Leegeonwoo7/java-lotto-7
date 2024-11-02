package lotto;

import lotto.constant.LottoRange;

import java.util.List;

import static lotto.constant.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplication(numbers);
        validateLottoRange(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        boolean isDuplicate = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (isDuplicate) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        if (!LottoRange.isAvailableRange(numbers)) {
            throw new IllegalArgumentException(NUMBERS_RANGE_ERROR.getMessage());
        }
    }
}
