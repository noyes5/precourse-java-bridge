package bridge.view;

import bridge.domain.DisplayBridge;
import bridge.domain.GameResult;
import bridge.domain.GameState;
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

    public void printStart() {
        System.out.println(Message.GAME_INTRO.message);
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
    public void printResult(GameResult gameResult) {
        System.out.println(Message.RESULT_INTRO.message);
        printMap(gameResult.getResultBridge());
        printGameState(gameResult.getGameState());
        printTotalTryCount(gameResult.getTotalTryCount());
    }

    private void printGameState(GameState gameState) {
        System.out.println(String.format(Message.RESULT_GAME_STATE.message, gameState.getDisplay()));
    }

    private void printTotalTryCount(int totalTryCount) {
        System.out.println(String.format(Message.RESULT_TOTAL_TRY_COUNT.message, totalTryCount));
    }


    private enum Message {
        GAME_INTRO("다리건너기 게임을 시작합니다."),
        RESULT_INTRO("최종 게임 결과"),
        RESULT_GAME_STATE("게임 성공 여부: %s"),
        RESULT_TOTAL_TRY_COUNT("총 시도한 횟수: %d");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
