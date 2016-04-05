package someapp.vo;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserId userId = (UserId) o;
        return value == userId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserId{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
