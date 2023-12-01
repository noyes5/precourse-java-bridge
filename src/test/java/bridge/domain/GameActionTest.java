package bridge.domain;

import static bridge.util.BridgeException.ERROR_GAME_COMMAND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameActionTest {

    @DisplayName("유효하지 않은 값이 들어오면 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "재시작", "12312"})
    void 유효하지않은_입력_검증(String input) {
        assertThatThrownBy(() -> GameAction.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_GAME_COMMAND.getMessage());
    }
}