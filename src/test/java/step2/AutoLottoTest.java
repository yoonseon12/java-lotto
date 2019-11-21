package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.model.AutoLotto;
import step2.model.Rank;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AutoLottoTest {
	AutoLotto lotto;

	@Test
	void 자동_로또_생성_테스트() {
		lotto = new AutoLotto();
		List<Integer> numbers = lotto.getNumbers();
		System.out.println(numbers);
		assertThat(numbers).hasSize(6);
		assertThat(new HashSet<>(numbers)).hasSize(6);
		assertThat(numbers).isSorted();
		assertThat(Collections.min(numbers)).isGreaterThanOrEqualTo(1);
		assertThat(Collections.max(numbers)).isLessThanOrEqualTo(45);
	}

	@Test
	void 로또_결과_비교() {
		lotto = new AutoLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto.getRank("1,2,3,4,5,6")).isEqualTo(Rank.FIRST);
		assertThat(lotto.getRank("1,2,3,4,5,7")).isEqualTo(Rank.SECOND);
		assertThat(lotto.getRank("1,2,3,4,7,8")).isEqualTo(Rank.THIRD);
		assertThat(lotto.getRank("1,2,3,7,8,9")).isEqualTo(Rank.FOURTH);
		assertThat(lotto.getRank("1,2,7,8,9,10")).isEqualTo(Rank.LOSE);
	}
}
