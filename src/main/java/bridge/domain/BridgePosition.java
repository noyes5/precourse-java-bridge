package bridge.domain;

import static bridge.domain.BridgeException.INVALID_BRIDGE_SPACE;

import java.util.Arrays;

public enum BridgePosition {
    DOWN("D", 0),
    UP("U", 1);

    private final String moveSymbol;
    private final int positionValue;

    BridgePosition(String moveSymbol, int positionValue) {
        this.moveSymbol = moveSymbol;
        this.positionValue = positionValue;
    }

    public static String makeBridgeSpace(int inputNumber) {
        if (inputNumber == BridgePosition.UP.positionValue) {
            return BridgePosition.UP.moveSymbol;
        }
        return BridgePosition.DOWN.moveSymbol;
    }

    public static BridgePosition makeBridgeSymbol(String moveSymbol) {
        return Arrays.stream(values())
                .filter(value -> value.moveSymbol.equals(moveSymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_BRIDGE_SPACE.getMessage()));
    }
}
