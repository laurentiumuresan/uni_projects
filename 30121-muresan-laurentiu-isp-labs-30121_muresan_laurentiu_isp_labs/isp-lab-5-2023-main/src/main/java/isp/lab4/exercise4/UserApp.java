package isp.lab4.exercise4;

import java.util.Random;

public class UserApp extends TicketsManager{
    private User user;
    private final Ticket ticket= new Ticket();
    private PaymentGateway paymentGateway;
    private OrganiserApp app= new OrganiserApp();

    public void buyTicket() {
        generateTicket();
        app.validateTicket(ticket);
        System.out.println(ticket.toString());
        PaymentGateway.payTicket(ticket);
    }
    public void generateTicket() {
        Random random = new Random();
        int ticketId = random.nextInt(1000);
        ticket.setTicketId(ticketId);
    }
    public void viewTicket(){
        System.out.println("Your ticket id is: " +ticket.getTicketId());
    }
}
