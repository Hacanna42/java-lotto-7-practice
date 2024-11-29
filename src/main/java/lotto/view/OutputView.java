package lotto.view;

import java.util.EnumMap;
import lotto.domain.Prize;
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

    public static void printPrizeResult(EnumMap<Prize, Integer> prizeResult) {
        printPrizeResultNotice();
        for (Prize currentPrize : Prize.values()) {
            if (currentPrize == Prize.NONE) {
                continue;
            }
            printPrizeCondition(currentPrize);
            printPrizeMoney(currentPrize);
            System.out.print(" - ");
            printPrizeCount(prizeResult.get(currentPrize));
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + Math.round(rateOfReturn * 10) / 10.0 + "%입니다.");
    }

    private static void printPrizeResultNotice() {
        System.out.println("당첨 통계\n---");
    }

    private static void printPrizeCondition(Prize prize) {
        if (prize.isRequireBonusNumber()) {
            System.out.print(prize.getRequireCount() + "개 일치, 보너스 볼 일치 ");
            return;
        }
        System.out.print(prize.getRequireCount() + "개 일치 ");
    }

    private static void printPrizeMoney(Prize prize) {
        System.out.printf("(%,d원)", prize.getPrizeMoney());
    }

    private static void printPrizeCount(int count) {
        System.out.println(count + "개");
    }
}
