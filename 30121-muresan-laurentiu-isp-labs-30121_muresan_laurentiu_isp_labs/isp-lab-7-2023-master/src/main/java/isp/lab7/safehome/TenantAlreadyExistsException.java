package isp.lab7.safehome;

public class TenantAlreadyExistsException extends RuntimeException {
    public TenantAlreadyExistsException(){};
    public TenantAlreadyExistsException(String message){
        super(message);
    }

}
