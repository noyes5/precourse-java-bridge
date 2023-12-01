package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStateTest {

    @DisplayName("성공 여부 테스트")
    @Test
    void 성공_여부_검증() {
        assertThat(GameState.SUCCESS.isSuccess()).isTrue();
    }

    @DisplayName("실패 여부 테스트")
    @Test
    void 실패_여부_검증() {
        assertThat(GameState.FAILURE.isSuccess()).isFalse();
    }
}