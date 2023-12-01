package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
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
}
