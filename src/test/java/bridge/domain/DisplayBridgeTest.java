package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DisplayBridgeTest {
    private DisplayBridge displayBridge;
    private boolean isSamePosition;

    @BeforeEach
    void setUp() {
        displayBridge = new DisplayBridge();
        isSamePosition = true;
    }

    @DisplayName("동일한 포지션이 들어오면 위쪽 다리가 추가되는 테스트")
    @Test
    void 위쪽다리_업데이트() {
        displayBridge.updateBridge(BridgePosition.UP, MoveResult.from(isSamePosition));
        assertThat(displayBridge.getUpperBridge().size()).isEqualTo(1);
    }

    @DisplayName("다른 포지션이 들어와도 위쪽 다리가 추가되는 테스트")
    @Test
    void 위쪽다리_업데이트2() {
        displayBridge.updateBridge(BridgePosition.UP, MoveResult.from(!isSamePosition));
        assertThat(displayBridge.getUpperBridge().size()).isEqualTo(1);
    }

    @DisplayName("동일한 포지션이 들어오면 아래다리가 추가되는 테스트")
    @Test
    void 아래쪽다리_업데이트() {
        displayBridge.updateBridge(BridgePosition.DOWN, MoveResult.from(!isSamePosition));
        assertThat(displayBridge.getUpperBridge().size()).isEqualTo(1);
    }

    @DisplayName("다른 포지션이 들어와도 아래다리가 추가되는 테스트")
    @Test
    void 아래쪽다리_업데이트2() {
        displayBridge.updateBridge(BridgePosition.UP, MoveResult.from(!isSamePosition));
        assertThat(displayBridge.getUpperBridge().size()).isEqualTo(1);
    }

}