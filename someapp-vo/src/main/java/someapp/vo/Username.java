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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Username username = (Username) o;
        return Objects.equals(value, username.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Username{");
        sb.append("value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
