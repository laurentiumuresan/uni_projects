package isp.lab6.exercise3;

public class CheckOutPage {
    private ActiveSession activeSession = new ActiveSession();

    public CheckOutPage() {
    }

    public void setActiveSession(ActiveSession activeSession) {
        this.activeSession = activeSession;
    }

    public CheckOutPage(ActiveSession activeSession) {
        this.activeSession = activeSession;
    }

    public void payProducts(double budget) {
        if (budget < activeSession.getTotalCost()) {
            System.out.println("Your budget is not enough!");
        } else {
            System.out.println("Your payment is processing!");
            System.out.println("You payed successfully!");
        }
    }

    public void orderReview() {
        System.out.println("Your products:");
      System.out.println(activeSession.toString());
    }

    public void shippingInformation() {
        System.out.println("Shipping methods we offer are standard shipping, express shipping, or same-day delivery.");
    }

    public void placeOrder() {
        System.out.println("Thank you for your order!");
        System.out.println("We are waiting for you to come back!");
    }
}
