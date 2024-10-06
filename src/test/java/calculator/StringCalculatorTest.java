package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다.")
    void throwExceptionWhenInputIsNullOrEmpty(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값에 null 또는 공백만 존재하여 계산을 할 수 없습니다.");
    }

    @Test
    @DisplayName("입력값이 덧셈 연산으로만 이루어졌을 때 calculate 메서드가 덧셈을 수행한다.")
    void sumTest() {
        String input = "100 + 200 + 300";
        int expectValue = 600;
        assertThat(StringCalculator.calculate(input))
                .isEqualTo(expectValue);
    }
}
