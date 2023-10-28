package isp.lab4.exercise4;

public class Organiser extends Participant {
    private String organiserName;
    private String organiserId;

    public Organiser(String organiserName, String organiserId) {
        this.organiserName = organiserName;
        this.organiserId = organiserId;
    }

    public String getOrganiserId() {
        return organiserId;
    }

    public String getOrganiserName() {
        return organiserName;
    }

    public String toString() {
        return "Organiser{" +
                "organiserName='" + organiserName + '\'' +
                ", organiserId='" + organiserId+ '\'' +
                '}';
    }}
