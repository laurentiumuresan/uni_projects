package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.*;

public class DoorLockController implements ControllerInterface {
    private Map<Tenant, AccessKey> validAccess = new HashMap<>();
    private Set<AccessKey> keys = new HashSet<>();
    private Set<Tenant> tenants = new HashSet<>();
    private List<AccessLog> logs = new ArrayList<>();
    private Door door = new Door();
    private int numberOfTries = 0;

    public DoorStatus enterPin(String pin) throws TooManyAttemptsException, InvalidPinException {
        if (pin.equals(ControllerInterface.MASTER_KEY)) {
            door.unlockDoor();
            AccessLog log = new AccessLog("Master", LocalDateTime.now(), "Master key used", door.getStatus(), "no error");
            logs.add(log);
            numberOfTries = 0;
            return door.getStatus();

        }
        if (validAccess.containsValue(new AccessKey(pin))) {
            if (door.getStatus() == DoorStatus.OPEN) {
                door.lockDoor();
                AccessLog log = new AccessLog(getKeyByValue(pin), LocalDateTime.now(), "enter pin", door.getStatus(), "no error");
                logs.add(log);
            } else {
                door.unlockDoor();
                AccessLog log = new AccessLog(getKeyByValue(pin), LocalDateTime.now(), "enter pin", door.getStatus(), "no error");
                logs.add(log);
            }
            return door.getStatus();
        } else {
            numberOfTries++;
            if (numberOfTries >= 3) {
                door.lockDoor();
                AccessLog log = new AccessLog(getKeyByValue(pin), LocalDateTime.now(), "enter pin", door.getStatus(), "Too many tries");
                logs.add(log);
                throw new TooManyAttemptsException();
            } else {
                AccessLog log = new AccessLog(getKeyByValue(pin), LocalDateTime.now(), "enter pin", door.getStatus(), "invalid pin");
                logs.add(log);
                throw new InvalidPinException();

            }
        }
    }

    public void addTenant(String pin, String name) throws TenantAlreadyExistsException {
        if (validAccess.containsKey(new Tenant(name))) {
            throw new TenantAlreadyExistsException();
        }
        validAccess.put(new Tenant(name), new AccessKey(pin));

    }


    public void removeTenant(String name) throws TenantNotFoundException {
        if (!validAccess.containsKey(new Tenant(name))) {
            throw new TenantNotFoundException();
        }
        validAccess.remove(new Tenant(name));

    }

    public String getLogs() {
        return logs.toString();
    }

    public void setLogs(List<AccessLog> logs) {
        this.logs = logs;
    }

    public String getKeyByValue(String value) {
        for (Map.Entry<Tenant, AccessKey> entry : validAccess.entrySet()) {
            if (entry.getValue().getPin().equals(value)) {
                return entry.getKey().getName();
            }
        }
        return null;
    }
}
