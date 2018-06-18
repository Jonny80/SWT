import java.util.Iterator;
import java.util.List;

/**
 * Created by jonny on 10.06.17.
 */
public class Payroll {
    private int payday;
    private PayrollDispositionImpl disposition;

    public Payroll(PayrollDispositionImpl disposition,int payday){
        if (disposition == null){
            throw new NullPointerException("");
        }else {
            this.disposition = disposition;
        }
        if (payday <= 0 || payday > 31){
            throw new IllegalArgumentException("");
        }else {
            this.payday = payday;
        }
    }
    public void doPayroll(PayrollDB db) {
        Iterator<Employee> iterator = db.getEmployeeList().iterator();
        if (!iterator.hasNext()){
            throw new NullPointerException("");
        }
        if (db.getEmployeeList() == null || db == null){
            throw new NullPointerException("e1");
        }
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println(employee.getId());
            try {
                disposition.sendPayment(employee,employee.calculatePay()-employee.calculateDeductions());
                System.out.println(employee.calculatePay()-employee.calculateDeductions());
            } catch (UnpayableEmployeeException e) {
            }
            if (!employee.isPayday(payday)){
                disposition.getPayments().remove(employee);
            }
            System.out.println(disposition.getPayments().size());
            //employee = iterator.next();
        }
    }
}
