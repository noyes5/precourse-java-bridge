package bridge.domain;

import static bridge.util.BridgeException.ERROR_GAME_COMMAND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameActionTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "재시작", "12312"})
    void 잘못된_입력값(String input) {
        assertThatThrownBy(() -> GameAction.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_GAME_COMMAND.getMessage());
    }
}