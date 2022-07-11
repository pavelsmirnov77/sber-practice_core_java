package stream_api;

import java.util.Optional;

public class StreamClass {
    public static StreamClass createInstance(StreamClass streamClass) {
        return Optional.ofNullable(streamClass).orElseGet(StreamClass::new);
    }
}
