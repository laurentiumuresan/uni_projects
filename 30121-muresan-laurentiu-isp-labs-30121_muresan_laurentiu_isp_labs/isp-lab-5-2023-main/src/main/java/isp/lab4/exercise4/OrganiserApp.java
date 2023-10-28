package isp.lab4.exercise4;

public class OrganiserApp extends TicketsManager{
    private Organiser organizer;
    public Organiser getOrganizer() {
        return organizer;
    }

    public void scanTicket(Ticket ticket) {
        System.out.println("You just scanned the ticket with the Id: " + ticket.getTicketId());
    }
    public  void validateTicket(Ticket ticket) {
        if (ticket.getTicketId() != 0) {
            ticket.setValid(true);
            System.out.println("Your ticket is valid!");
        } else {
            System.out.println("Your ticket is not valid!");
        }
    }

    public void checkIn() {
        System.out.println("You just checked in successfully!");
    }
}
