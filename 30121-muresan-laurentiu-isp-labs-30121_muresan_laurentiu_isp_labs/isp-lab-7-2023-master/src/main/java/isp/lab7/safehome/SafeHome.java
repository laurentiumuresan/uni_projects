package isp.lab7.safehome;

public class SafeHome {

    public static void main(String[] args) throws TenantAlreadyExistsException, TenantNotFoundException, TooManyAttemptsException, InvalidPinException {
        DoorLockController doorLockController = new DoorLockController();
//        doorLockController.addTenant("123", "lau");
//        DoorStatus doorStatus=doorLockController.enterPin("123");
//        System.out.println(doorStatus);
//        doorLockController.addTenant("111","narcis");
//        DoorStatus doorStatus1=doorLockController.enterPin("1223");
//        System.out.println(doorStatus1);
//        DoorStatus doorStatus2=doorLockController.enterPin("111");
//        System.out.println(doorStatus2);
//        doorStatus2=doorLockController.enterPin("111");
//        System.out.println(doorStatus2);
//         doorLockController.addTenant("123","lau");
//         doorLockController.removeTenant("adi");
//         doorStatus1=doorLockController.enterPin("1523");
//         System.out.println(doorStatus1);
//       doorLockController.enterPin("1235");
//        doorLockController.enterPin("5123");
//       doorLockController.enterPin("1233");
          UserInterface userInterface=new UserInterface();
          userInterface.loadInterface();
    }
}
