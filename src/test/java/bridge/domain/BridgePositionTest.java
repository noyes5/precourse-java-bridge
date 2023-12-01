package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgePositionTest {

    @DisplayName("숫자가 입력되면 해당하는 심볼이 반환되는지 테스트")
    @ParameterizedTest
    @CsvSource({
            "1, U",
            "0, D"
    })
    void 숫자를_위치로_반환_검증(int inputNumber, String expected) {
        assertThat(BridgePosition.makeBridgeSpace(inputNumber)).isEqualTo(expected);
    }

    @DisplayName("U가 입력되면 UP을 반환하는지 테스트")
    @Test
    void U일때_정상적으로_반환_검증() {
        assertThat(BridgePosition.from("U")).isEqualTo(BridgePosition.UP);
    }

    @DisplayName("D가 입력되면 DOWN을 반환하는지 테스트")
    @Test
    void D일때_정상적으로_반환_검증() {
        assertThat(BridgePosition.from("D")).isEqualTo(BridgePosition.DOWN);
    }
}