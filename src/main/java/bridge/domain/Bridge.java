package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<BridgePosition> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>();
        makeBridge(bridge);
    }

    private void makeBridge(List<String> bridge) {
        for (String moveSymbol : bridge) {
            BridgePosition position = BridgePosition.makeBridgeSymbol(moveSymbol);
            this.bridge.add(position);
        }
    }
}
