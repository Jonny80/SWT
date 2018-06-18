/**
 * Created by jonny on 10.06.17.
 */
import java.lang.Exception;


public class UnpayableEmployeeException extends Exception {
    private String message;
    UnpayableEmployeeException(String message){
        this.message = message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
