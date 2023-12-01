package bridge.domain;

import static bridge.util.BridgeException.ERROR_GAME_COMMAND;

import java.util.Arrays;

public enum GameAction {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameAction(String command) {
        this.command = command;
    }

    public static GameAction from(String input) {
        return Arrays.stream(GameAction.values())
                .filter(command -> command.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_GAME_COMMAND.getMessage()));
    }
}
