package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.LottoNumbersDto;
import lotto.dto.LottoNumbersDtos;
import lotto.util.LottoNumbersGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateLottos(LottoNumbersGenerator generator, int amount) {
        List<Lotto> lottos = IntStream.range(0, amount)
                .mapToObj(i -> Lotto.generateRandomLotto(generator))
                .toList();

        return new Lottos(lottos);
    }

    public LottoNumbersDtos getLottoNumbersDtos() {
        List<LottoNumbersDto> lottoNumbersDtos = lottos.stream()
                .map(Lotto::getLottoNumbersDto)
                .toList();

        return new LottoNumbersDtos(lottoNumbersDtos);
    }
}
