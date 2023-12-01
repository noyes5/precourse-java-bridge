package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisplayBridge {
    private List<String> upperBridge = new ArrayList<>();
    private List<String> lowerBridge = new ArrayList<>();

    public void updateBridge(BridgePosition position, MoveResult moveResult) {
        upperBridge.add(moveResult.getResult(position.isRightPlace(BridgePosition.UP)));
        lowerBridge.add(moveResult.getResult(position.isRightPlace(BridgePosition.DOWN)));
    }

    public List<String> getUpperBridge() {
        return Collections.unmodifiableList(upperBridge);
    }

    public List<String> getLowerBridge() {
        return Collections.unmodifiableList(lowerBridge);
    }
}
