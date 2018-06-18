/**
 * Created by jonny on 12.06.17.
 */
public class Sale {
    private long preDiscountTotal;
    private ISalePricing pricing1;

    Sale(long preDiscountTotal,ISalePricing myPricing){
        if (myPricing == null){
            throw new NullPointerException("");
        }
        if (preDiscountTotal < 0){
            throw new IllegalArgumentException("");
        }
        this.preDiscountTotal = preDiscountTotal;
        this.pricing1 = myPricing;

    }

    public long getPreDiscountTotal(){
        return preDiscountTotal;
    }

    public void setPricing(ISalePricing pricing1) {
        if (pricing1 == null){
            throw new NullPointerException("");
        }
        this.pricing1 = pricing1;
    }

    public static ISalePricing createPricing(DiscountType discountType, double percentage, long discount, long threshold){
        if (discountType == null){
            throw new NullPointerException("");
        }
        if (discountType.equals(DiscountType.PERCENTAGEDISCOUNT)){
            return new PercentageDiscountPricing(percentage);
        }else {
            return new AbsoluteDiscountPricing(discount,threshold);

        }
        //if (discountType.equals(DiscountType.ABSOLUTEDISCOUNT)){
        //}

    }

    public long getTotal() {
        return pricing1.getTotal(this);
    }
}
