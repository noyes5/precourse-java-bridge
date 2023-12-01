package bridge.domain;

public enum GameState {
    SUCCESS("성공",true),
    FAILURE("실패",false);

    private final String display;
    private final boolean isSuccess;

    GameState(String display, boolean isSuccess) {
        this.display = display;
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public String getDisplay() {
        return display;
    }
}
