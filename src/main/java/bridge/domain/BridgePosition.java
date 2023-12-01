package bridge.domain;

public enum BridgePosition {
    DOWN("D", 0),
    UP("U", 1);

    private final String canMove;
    private final int positionValue;

    BridgePosition(String canMove, int positionValue) {
        this.canMove = canMove;
        this.positionValue = positionValue;
    }

    public static String makeBridgeSpace(int inputNumber) {
        if (inputNumber == BridgePosition.UP.positionValue) {
            return BridgePosition.UP.canMove;
        }
        return BridgePosition.DOWN.canMove;
    }
}
