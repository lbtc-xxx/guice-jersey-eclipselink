package someapp.vo;

import com.fasterxml.jackson.annotation.JsonValue;

public class UserId {

    private final long value;

    public UserId(final String value) throws MyValidationException {
        this(Long.parseLong(value));
    }

    public UserId(final long value) throws MyValidationException {
        if (value < 1) {
            throw new MyValidationException();
        }
        this.value = value;
    }

    @JsonValue
    public long getValue() {
        return value;
    }
}
