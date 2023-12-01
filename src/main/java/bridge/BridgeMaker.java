package bridge;

import static bridge.util.BridgeException.INVALID_BRIDGE_SIZE;
import static bridge.util.Constants.MAX_BRIDGE_SIZE;
import static bridge.util.Constants.MIN_BRIDGE_SIZE;

import bridge.domain.BridgePosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateBridgeSizeRange(size);
        List<String> bridge = new ArrayList<>(size);
        
        IntStream.range(0, size)
                .mapToObj(i -> bridgeNumberGenerator.generate())
                .map(this::makeAnswerSpace)
                .forEach(bridge::add);

        return Collections.unmodifiableList(bridge);
    }

    private void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public String makeAnswerSpace(int randomNumber) {
        return BridgePosition.makeBridgeSpace(randomNumber);
    }
}
