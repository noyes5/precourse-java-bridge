package bridge.domain;

import static bridge.util.Constants.INITIAL_ATTEMPTS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = GameResult.byDefault();
    }

    @DisplayName("초기 결과값 실패 테스트")
    @Test
    void 결과값_실퍠_검증() {
        assertThat(gameResult.getGameState()).isEqualTo(GameState.FAILURE);
    }

    @DisplayName("게임 이기면 성공 테스트")
    @Test
    void 결과값_성공_검증() {
        gameResult.winningGame();
        assertThat(gameResult.getGameState()).isEqualTo(GameState.SUCCESS);
    }

    @DisplayName("시도횟수 추가시 테스트")
    @Test
    void 시도횟수_추가() {
        gameResult.addTryCount();
        assertThat(INITIAL_ATTEMPTS + 1).isEqualTo(gameResult.getTotalTryCount());
    }

    @DisplayName("위로 이동시 위쪽다리가 올바른 값인지 테스트")
    @Test
    void 위로_이동시_위쪽다리_검증() {
        BridgePosition position = BridgePosition.UP;
        MoveResult moveResult = MoveResult.SAME;
        gameResult.update(position, moveResult);
        List<String> moveSymbol = List.of(moveResult.getResult(!moveResult.isDifferent()));

        assertThat(gameResult.getResultBridge().getUpperBridge()).isEqualTo(moveSymbol);
    }

    @DisplayName("위로 이동시 아래쪽다리가 올바른 값인지 테스트")
    @Test
    void 위로_이동시_아래쪽다리_검증() {
        BridgePosition position = BridgePosition.UP;
        MoveResult moveResult = MoveResult.DIFFERENT;

        gameResult.update(position, moveResult);
        List<String> moveSymbol = List.of(moveResult.getResult(!moveResult.isDifferent()));

        assertThat(gameResult.getResultBridge().getLowerBridge()).isEqualTo(moveSymbol);
    }

    @DisplayName("아래로 이동시 위쪽다리가 올바른 값인지 테스트")
    @Test
    void 아래로_이동시_위쪽다리_검증() {
        BridgePosition position = BridgePosition.DOWN;
        MoveResult moveResult = MoveResult.DIFFERENT;
        gameResult.update(position, moveResult);
        List<String> moveSymbol = List.of(moveResult.getResult(!moveResult.isDifferent()));

        assertThat(gameResult.getResultBridge().getUpperBridge()).isEqualTo(moveSymbol);
    }

    @DisplayName("아래로 이동시 아래쪽다리가 올바른 값인지 테스트")
    @Test
    void 아래로_이동시_아래쪽다리_검증() {
        BridgePosition position = BridgePosition.DOWN;
        MoveResult moveResult = MoveResult.SAME;
        gameResult.update(position, moveResult);
        List<String> moveSymbol = List.of(moveResult.getResult(!moveResult.isDifferent()));

        assertThat(gameResult.getResultBridge().getLowerBridge()).isEqualTo(moveSymbol);
    }
}