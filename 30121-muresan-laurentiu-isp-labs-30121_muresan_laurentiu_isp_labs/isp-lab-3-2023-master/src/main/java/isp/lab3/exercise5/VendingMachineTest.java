package isp.lab3.exercise5;

public class VendingMachineTest {

    public static void main(String[] args) {
        VendingMachine MyVendingMachine = new VendingMachine();
        MyVendingMachine.displayProducts();
        MyVendingMachine.insertCoin(6);
        MyVendingMachine.selectProduct(20);
        MyVendingMachine.displayCredit();
    }
}
