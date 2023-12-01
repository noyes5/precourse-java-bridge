package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgePosition;
import bridge.domain.GameAction;
import bridge.domain.GameState;
import bridge.domain.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.stream.IntStream;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        startGame();
        makeBridge();
        tryGame();
        printResult();
    }

    public void startGame() {
        outputView.printStart();
    }

    private void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(readBridgeSize()));
        this.bridgeGame = new BridgeGame(bridge);
    }

    private int readBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private void tryGame() {
        GameState gameState = getGameStatus();
        if (gameState.isSuccess()) {
            handleSuccess();
            return;
        }
        handleFailure();
    }

    private GameState getGameStatus() {
        return IntStream.range(0, bridgeGame.getBridgeSize())
                .mapToObj(this::moveBridge)
                .filter(MoveResult::isDifferent)
                .findFirst()
                .map(result -> GameState.FAILURE)
                .orElse(GameState.SUCCESS);
    }

    private MoveResult moveBridge(int location) {
        BridgePosition position = readMoving();
        MoveResult moveResult = bridgeGame.move(location, position);
        outputView.printMap(bridgeGame.getDisplayBridge());
        return moveResult;
    }

    private BridgePosition readMoving() {
        while (true) {
            try {
                return BridgePosition.from(inputView.readMoving());
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private void handleSuccess() {
        bridgeGame.winningGame();
    }

    private void handleFailure() {
        if (isContinue()) {
            bridgeGame.retry();
            tryGame();
        }
    }

    private boolean isContinue() {
        return GameAction.RETRY == readRetryOrQuit();
    }

    private GameAction readRetryOrQuit() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private void printResult() {
        outputView.printResult(bridgeGame.getGameResult());
    }
}
