package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private GameResult gameResult;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.gameResult = GameResult.byDefault();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(int location, BridgePosition position) {
        MoveResult moveResult = MoveResult.from(bridge.isSamePosition(location, position));
        gameResult.update(position, moveResult);
        return moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameResult.initializeBridge();
        gameResult.addTryCount();
    }

    public int getBridgeSize() {
        return bridge.getSize();
    }

    public DisplayBridge getDisplayBridge() {
        return gameResult.getResultBridge();
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void winningGame() {
        gameResult.winningGame();
    }
}
