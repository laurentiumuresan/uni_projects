package isp.lab6.exercise3;

import org.junit.Assert;
import org.junit.Test;

public class OnlineStoreTest {
    OnlineStore store = new OnlineStore();
    UserInterface userInterface = new UserInterface();

    LoginSystem loginSystem = new LoginSystem();

    @Test

    public void logInTest() {
        User user = new User("adi", "123");
        loginSystem.logIn("adi", "123");
        Assert.assertEquals(false, loginSystem.logIn("adi", "123"));
    }

    @Test

    public void registerTest() {
        User user = new User("adi", "123");
        loginSystem.register("adi", "123");
        loginSystem.logIn("adi", "123");
        Assert.assertEquals(true, loginSystem.logIn("adi", "123"));
    }

    @Test

    public void equalsProductTest() {
        Product product1 = new Product("laptop", 1200);
        Product product2 = new Product("laptop", 2300);
        Product product3 = new Product("laptop", 2300);
        Assert.assertEquals(false, product1.equal(product2));
        Assert.assertEquals(true, product2.equal(product3));
    }


}
