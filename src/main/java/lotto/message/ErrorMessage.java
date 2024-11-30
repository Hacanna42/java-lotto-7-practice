package lotto.message;

public enum ErrorMessage {
    BONUS_NUMBER_DUPLICATED("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호는 중복될 수 없습니다."),
    MONEY_UNIT("로또 구입 금액은 1,000원 단위로 입력해야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
