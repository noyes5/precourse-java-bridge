package bridge.domain;

import static bridge.util.Constants.INITIAL_ATTEMPTS;

public class GameResult {
    private int totalTryCount;
    private GameState gameState;
    private DisplayBridge displayBridge;

    private GameResult(int totalTryCount, GameState gameState, DisplayBridge displayBridge) {
        this.totalTryCount = totalTryCount;
        this.gameState = gameState;
        this.displayBridge = displayBridge;
    }

    public static GameResult byDefault() {
        return new GameResult(INITIAL_ATTEMPTS, GameState.FAILURE, new DisplayBridge());
    }

    public void addTryCount() {
        totalTryCount++;
    }

    public DisplayBridge getResultBridge() {
        return displayBridge;
    }

    public void update(BridgePosition position, MoveResult moveResult) {
        displayBridge.updateBridge(position, moveResult);
    }

    public void initializeBridge() {
        displayBridge = new DisplayBridge();
    }

    public void winningGame() {
        this.gameState = GameState.SUCCESS;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }

    public GameState getGameState() {
        return gameState;
    }
}
