package someapp.vo;

import com.fasterxml.jackson.annotation.JsonValue;

public class Username {

    private final String value;

    public Username(final String value) throws MyValidationException {
        if (value == null) {
            throw new MyValidationException();
        }
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
