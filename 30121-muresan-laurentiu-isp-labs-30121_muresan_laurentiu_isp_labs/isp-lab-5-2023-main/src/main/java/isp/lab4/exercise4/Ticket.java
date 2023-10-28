package isp.lab4.exercise4;

public class Ticket {
    private int ticketId;
    private boolean valid;
    Ticket ticket;

    public Ticket() {
    }
    public Ticket(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public boolean isValid() {
        return valid;
    }
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                "valid='" +valid+'\''+
                '}';
    }
}
