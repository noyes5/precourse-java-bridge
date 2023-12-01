package bridge.view;

import static bridge.domain.BridgeException.BLANK_BRIDGE_LENGTH;
import static bridge.domain.BridgeException.INVALID_BRIDGE_SIZE;
import static bridge.domain.BridgeException.INVALID_NUMERIC_INPUT;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.INPUT_BRIDGE_SIZE.message);
        String inputBridgeSize = Console.readLine();
        validateBridgeSize(inputBridgeSize);
        return Integer.parseInt(inputBridgeSize);
    }

    private void validateBridgeSize(String inputBridgeSize) {
        validateBridgeSizeIsBlank(inputBridgeSize);
        int bridgeSize = isNumeric(inputBridgeSize);
        validateBridgeSizeRange(bridgeSize);
    }

    private static void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    private void validateBridgeSizeIsBlank(String inputBridgeSize) {
        if (inputBridgeSize.isBlank()) {
            throw new IllegalArgumentException(BLANK_BRIDGE_LENGTH.getMessage());
        }
    }

    private static int isNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private enum Message {
        INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
