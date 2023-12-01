package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isSamePosition(int location, BridgePosition position) {
        return position.isSame(bridge.get(location));
    }

    public int getSize() {
        return bridge.size();
    }
}
