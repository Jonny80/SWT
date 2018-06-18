/**
 * Created by jonny on 12.06.17.
 */
public class PercentageDiscountPricing implements ISalePricing {
    private double percentage;

    PercentageDiscountPricing(double percentage){
        if (percentage < 0 || percentage > 100){
            throw new IllegalArgumentException("");
        }else {
            this.percentage = percentage;
        }
    }
    @Override
    public long getTotal(Sale sale) {
        if (sale == null){
            throw new NullPointerException("");
        }else {
            return (long) (sale.getPreDiscountTotal() - (sale.getPreDiscountTotal()*(percentage/100)));
        }

    }
}
