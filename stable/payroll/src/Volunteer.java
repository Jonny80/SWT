/**
 * Created by jonny on 10.06.17.
 */
public class Volunteer extends Employee {
    public Volunteer(String id) {
        super(id);
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        throw new UnpayableEmployeeException("nein");
    }

    @Override
    public double calculateDeductions() {
        return 0;
    }

    @Override
    public boolean isPayday(int dayOfMonth){
        return false;
    }
}
