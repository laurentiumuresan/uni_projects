package isp.lab7.safehome;

import java.util.Objects;

public class AccessKey {
    private String pin;

    public AccessKey() {
    }

    public String getPin() {
        return pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessKey key = (AccessKey) o;
        return pin.equals(key.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin);
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public AccessKey(String pin) {
        this.pin = pin;
    }
}
