package bridge.domain;

import static bridge.util.BridgeException.INVALID_MOVE;

import java.util.Arrays;

public enum MoveResult {
    SAME("O", true),
    DIFFERENT("X", false),
    NONE(" ", false);

    private final String result;
    private final boolean isSame;

    MoveResult(String result, boolean isSame) {
        this.result = result;
        this.isSame = isSame;
    }

    public static MoveResult from(boolean samePosition) {
        return Arrays.stream(MoveResult.values())
                .filter(result -> result.isSame == samePosition)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MOVE.getMessage()));
    }

    public boolean isDifferent() {
        return this == MoveResult.DIFFERENT;
    }

    public String getResult(boolean isRightPlace) {
        if (isRightPlace) {
            return this.result;
        }
        return NONE.result;
    }
}
