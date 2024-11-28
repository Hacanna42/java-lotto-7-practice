package lotto.view;

import lotto.dto.LottoNumbersDto;
import lotto.dto.LottoNumbersDtos;

public class OutputView {
    public static void printBoughtAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printBoughtLottos(LottoNumbersDtos lottoNumbersDtos) {
        for (LottoNumbersDto lottoNumbersDto : lottoNumbersDtos.lottoNumbersDtos()) {
            System.out.println(lottoNumbersDto.numbers().toString());
        }
    }
}
