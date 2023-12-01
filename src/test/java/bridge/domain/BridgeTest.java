package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "D"));
    }

    @DisplayName("첫번째 위치가 같을때 테스트")
    @Test
    void 이동방향이_일치() {
        assertThat(bridge.isSamePosition(1, BridgePosition.DOWN)).isTrue();
    }

    @DisplayName("첫번째 위치가 다를때 테스트")
    @Test
    void 이동방향이_다름() {
        assertThat(bridge.isSamePosition(1, BridgePosition.UP)).isFalse();
    }

    @DisplayName("다리 길이 테스트")
    @Test
    void 사용자_이동방향과_비교() {
        assertThat(bridge.getSize()).isEqualTo(3);
    }

}