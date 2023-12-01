package bridge.util;

public enum BridgeException {
    BLANK_BRIDGE_LENGTH("다리 길이가 입력되지 않았습니다."),
    BLANK_MOVING_LENGTH("이동위치가 입력되지 않았습니다."),
    ERROR_GAME_COMMAND("재시도(R)와 종료(Q) 중에 입력해주세요."),
    INVALID_MOVE("올바른 값이 아닙니다."),
    INVALID_BRIDGE_SPACE("다리 이동은 U또는 D로만 가능합니다."),
    INVALID_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_NUMERIC_INPUT("다리 길이는 숫자만 입력 가능합니다.");

    private final String message;
    private static final String BASE_MESSAGE = "[ERROR] %s";

    BridgeException(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
