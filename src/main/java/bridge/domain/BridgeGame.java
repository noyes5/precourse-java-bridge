package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int location;
    private int totalTryCount;
    private Bridge bridge;

    public BridgeGame(int size, BridgeNumberGenerator generator) {
        this.location = 0;
        this.totalTryCount = 0;
        makeBridge(size, generator);
    }

    private void makeBridge(int size, BridgeNumberGenerator generator) {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(BridgePosition position) {
        this.location++;
        this.totalTryCount++;
        MoveResult moveResult = MoveResult.from(bridge.isSamePosition(location, position));
        return moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public int getBridgeSize() {
        return bridge.getSize();
    }

    public boolean isNotEnd() {
        return location != bridge.getSize();
    }
}
