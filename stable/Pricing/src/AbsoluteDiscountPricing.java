/**
 * Created by jonny on 12.06.17.
 */
public class AbsoluteDiscountPricing implements ISalePricing {
    private long discount;
    private long threshold;
    AbsoluteDiscountPricing(long discount,long threshold){
        if (discount < 0 || threshold < 0){
            throw new IllegalArgumentException("");
        }
        this.discount = discount;
        this.threshold = threshold;
    }

    @Override
    public long getTotal(Sale sale) {
        if (threshold > sale.getPreDiscountTotal()){
            return sale.getPreDiscountTotal();
        }else {
            if (sale.getPreDiscountTotal() - discount >threshold){
            return sale.getPreDiscountTotal() - discount;
            }
        }return threshold;
    }
}
