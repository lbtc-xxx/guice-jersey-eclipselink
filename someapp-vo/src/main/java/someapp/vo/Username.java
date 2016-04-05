package someapp.vo;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public class Username {

    private final String value;

    public Username(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
