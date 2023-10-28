package tests.exercise4;

import isp.lab4.exercise4.Organiser;
import isp.lab4.exercise4.Ticket;
import isp.lab4.exercise4.User;
import isp.lab4.exercise4.UserApp;

public class Exercise4Test {
    public static void main(String[] args) {
        User user=new User("Laurentiu", "default");
        user.setPassword("12345678");
        System.out.println(user.toString());
        Ticket ticket=new Ticket();
        UserApp app= new UserApp();
        app.buyTicket();
        Ticket ticket1= new Ticket(3242);
        System.out.println(ticket1.isValid());
        ticket1.setValid(true);
        System.out.println(ticket1.isValid());
        Organiser organiser=new Organiser("Alex","827378euw");
        System.out.println(organiser.toString());

    }
}
