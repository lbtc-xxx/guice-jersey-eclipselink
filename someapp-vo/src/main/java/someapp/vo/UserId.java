package someapp.vo;

import com.fasterxml.jackson.annotation.JsonValue;

public class UserId {

    private final long value;

    public UserId(final String value) {
        this(Long.parseLong(value));
    }

    public UserId(final long value) {
        if (value < 1) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @JsonValue
    public long getValue() {
        return value;
    }
}
