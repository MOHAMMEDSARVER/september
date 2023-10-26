package wallet;

public class InSufficinetFundsException extends RuntimeException{
    public InSufficinetFundsException(String message){
        super(message);
    }
}
