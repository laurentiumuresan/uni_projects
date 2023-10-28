package isp.lab4.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        User user=new User("Laurentiu", "default");
        user.setPassword("12345678");
        System.out.println(user.toString());
        Ticket ticket=new Ticket();
        UserApp app= new UserApp();
        app.buyTicket();
    }
}
