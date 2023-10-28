package isp.lab3.exercise6;

public class SingletonVendingMachineTest {

    public static void main(String[] args) {
        isp.lab3.exercise5.VendingMachine MyVendingMachine = new isp.lab3.exercise5.VendingMachine();
        MyVendingMachine.displayProducts();
        MyVendingMachine.insertCoin(6);
        MyVendingMachine.selectProduct(20);
        MyVendingMachine.displayCredit();
    }
}
