package bridge.domain;

public enum BridgeException {
    BLANK_BRIDGE_LENGTH("다리 길이가 입력되지 않았습니다."),
    INVALID_BRIDGE_SPACE("올바르지 않은 값으로 다리를 생성할 수 없습니다."),
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
