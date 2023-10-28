package isp.lab7.safehome;

import java.util.Scanner;

public class UserInterface {
    private Tenant tenant = new Tenant();
    DoorLockController lockController = new DoorLockController();

    public void setLockController(DoorLockController lockController) {
        this.lockController = lockController;
    }

    public void loadInterface() throws TooManyAttemptsException, InvalidPinException, TenantAlreadyExistsException, TenantNotFoundException {
        System.out.println("Enter your status:");
        System.out.println("1 for tenant");
        System.out.println("2 for admin");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                    System.out.println("Enter your pin:");
                    String pin =scanner.next();
                    lockController.enterPin(pin);
                break;
            case 2:
                adminOptions();
                break;
            default:
                System.out.println("Please select a valid status! \n");
                loadInterface();
                break;

        }
    }

    public void adminOptions() throws TooManyAttemptsException, InvalidPinException, TenantAlreadyExistsException, TenantNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your option: ");
        System.out.println("1 to enter pin");
        System.out.println("2 to add tenant ");
        System.out.println("3 to remove tenant ");
        System.out.println("4 to view access logs ");
        System.out.println("5 to go back ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.println("Enter your pin:");
                String pin = scanner.nextLine();
                lockController.enterPin(pin);
                adminOptions();
                break;
            case 2:
                System.out.println("Enter tenant name:");
                String name1 = scanner.nextLine();
                System.out.println("Enter tenant pin:");
                String tenantPin = scanner.nextLine();
                lockController.addTenant(tenantPin, name1);
                adminOptions();
                break;
            case 3:
                System.out.println("Enter tenant name:");
                String nameToRemove = scanner.nextLine();
                lockController.removeTenant(nameToRemove);
                adminOptions();
                break;
            case 4:
                System.out.println(lockController.getLogs()+"\n");
                adminOptions();
                break;
            case 5:
                loadInterface();
                break;
            default:
                System.out.println("Please select a valid option!");
                break;

        }
    }
}
