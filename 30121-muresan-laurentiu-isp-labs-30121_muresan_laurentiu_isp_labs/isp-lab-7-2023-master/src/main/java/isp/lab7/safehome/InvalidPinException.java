package isp.lab7.safehome;

public class InvalidPinException extends  RuntimeException{
   public InvalidPinException(){};
    public InvalidPinException(String message){
        super(message);
    }
}
