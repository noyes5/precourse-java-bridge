package bridge.view;

import bridge.domain.DisplayBridge;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String BRIDGE_START = "[ ";
    public static final String BRIDGE_SEPARATOR = " | ";
    public static final String BRIDGE_END = " ]";

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(DisplayBridge resultBridge) {
        List<String> upperBridge = resultBridge.getUpperBridge();
        List<String> lowerBridge = resultBridge.getLowerBridge();
        printUpperBridge(upperBridge);
        printLowerBridge(lowerBridge);
    }

    private void printUpperBridge(List<String> upperBridge) {
        StringJoiner result = new StringJoiner(BRIDGE_SEPARATOR, BRIDGE_START, BRIDGE_END);
        upperBridge.stream().forEach(element -> result.add(element));
        System.out.println(result);
    }

    private void printLowerBridge(List<String> lowerBridge) {
        StringJoiner result = new StringJoiner(BRIDGE_SEPARATOR, BRIDGE_START, BRIDGE_END);
        lowerBridge.stream().forEach(element -> result.add(element));
        System.out.println(result);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStart() {
        System.out.println(Message.GAME_INTRO.message);
    }

    private enum Message {
        GAME_INTRO("다리건너기 게임을 시작합니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
