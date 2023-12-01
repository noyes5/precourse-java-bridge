package bridge.view;

import static bridge.util.BridgeException.BLANK_BRIDGE_LENGTH;
import static bridge.util.BridgeException.BLANK_MOVING_LENGTH;
import static bridge.util.BridgeException.INVALID_NUMERIC_INPUT;
import static bridge.util.Constants.LINE_SEPARATOR;

import bridge.domain.GameAction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.print(LINE_SEPARATOR);
        System.out.println(Message.INPUT_BRIDGE_SIZE.message);
        String inputBridgeSize = Console.readLine();
        validateBridgeSize(inputBridgeSize);
        return Integer.parseInt(inputBridgeSize);
    }

    private void validateBridgeSize(String inputBridgeSize) {
        validateBridgeSizeIsBlank(inputBridgeSize);
        isNumeric(inputBridgeSize);
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
        System.out.print(LINE_SEPARATOR);
        System.out.println(Message.INPUT_MOVE_POSITION.message);
        String inputMoving = Console.readLine();
        validateMoving(inputMoving);
        return inputMoving;
    }

    private void validateMoving(String inputMoving) {
        validateMovingIsBlank(inputMoving);
    }

    private void validateMovingIsBlank(String inputMoving) {
        if (inputMoving.isBlank()) {
            throw new IllegalArgumentException(BLANK_MOVING_LENGTH.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameAction readGameCommand() {
        System.out.println(Message.INPUT_RETRY.message);
        return GameAction.from(Console.readLine());
    }

    private enum Message {
        INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
        INPUT_MOVE_POSITION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        INPUT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
