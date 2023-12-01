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

    public static BridgePosition from(String inputPosition) {
        return Arrays.stream(BridgePosition.values())
                .filter(position -> position.moveSymbol.equals(inputPosition))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_BRIDGE_SPACE.getMessage()));
    }

    public boolean isSame(String string) {
        return string.equals(this.moveSymbol);
    }
}
