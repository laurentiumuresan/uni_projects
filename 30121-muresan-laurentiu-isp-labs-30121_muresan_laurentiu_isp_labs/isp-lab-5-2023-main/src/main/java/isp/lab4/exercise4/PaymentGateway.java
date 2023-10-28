package isp.lab4.exercise4;

public class PaymentGateway {

    private String receipt;
    private Ticket ticket;
    private User user;
    public static void payTicket(Ticket ticket){
        System.out.println("You paid successfully!");
    }

    public String getReceipt() {
        return receipt;
    }
}
