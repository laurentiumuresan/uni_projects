package isp.lab7.safehome;

public class TenantNotFoundException extends RuntimeException{
    public TenantNotFoundException(){};
    public TenantNotFoundException(String message){
        super(message);
    }
}
