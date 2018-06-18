/**
 * Created by jonny on 13.06.17.
 */
public class ReceivingStock extends Stock{
    private int minStockitems;
    private int maxStockitems;

    public ReceivingStock(int minStockitems, int maxStockitems) {
        if (minStockitems < 0 || maxStockitems < minStockitems){
            throw new IllegalArgumentException("");
        }

        this.maxStockitems = maxStockitems;
        this.minStockitems = minStockitems;
    }

    public int getMinStockItems() {
        return minStockitems;
    }

    public int getMaxStockItems() {
        return maxStockitems;
    }

}
