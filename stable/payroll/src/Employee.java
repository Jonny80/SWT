/**
 * Created by jonny on 10.06.17.
 */
public abstract class Employee {
    private String id;


    public Employee(String id){
        if (id == null ){
            throw new NullPointerException("");
        }else if (id.isEmpty()){
            throw new IllegalArgumentException("");
        }else {
            this.id = id;
        }
    }


    public String getId(){
        return id;
    }

    public abstract boolean isPayday(int dayOfMonth);

    public abstract double calculatePay() throws UnpayableEmployeeException;

    public abstract double calculateDeductions();


}
