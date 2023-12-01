package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgePosition;
import bridge.domain.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void startGame() {
        outputView.printStart();
        makeBridge();
        while (true) {
            gameProgress();
        }
    }

    private void makeBridge() {
        int bridgeSize = readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize, new BridgeRandomNumberGenerator());
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

    public void gameProgress() {
        moveUntilEnd();
    }

    private void moveUntilEnd() {
        while (bridgeGame.isNotEnd()) {
            MoveResult moveResult = moveBridge();
        }
    }

    private MoveResult moveBridge() {
        BridgePosition position = BridgePosition.from(inputView.readMoving());
        MoveResult moveResult = bridgeGame.move(position);
        return moveResult;
    }
}
