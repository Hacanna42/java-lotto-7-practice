package lotto.service;

import java.util.Map;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;

public class LottoService {
    public void sendPrizeMoney(Money money, PrizeResult prizeResult) {
        for (Map.Entry<Prize, Integer> entry : prizeResult.getPrizeResult().entrySet()) {
            money.addMoneyByPrize(entry.getKey(), entry.getValue());
        }
    }
}
