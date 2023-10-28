package isp.lab7.safehome;

public class Door {

    private DoorStatus status;

    public Door() {
    }

    public Door(DoorStatus status) {
        this.status = status;
    }

    public void setStatus(DoorStatus status) {
        this.status = status;
    }

    public DoorStatus getStatus() {
        return status;
    }

    public void lockDoor(){
        setStatus(DoorStatus.CLOSE);
    }

    public void unlockDoor(){
        setStatus(DoorStatus.OPEN);
    }

}
