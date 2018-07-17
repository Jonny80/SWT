import java.util.LinkedList;
import java.util.List;

public class Item {
    private String name;
    private String description;
    private long minPrice;
    private List<Bid> list;
    private Bid highestBid;

    public Item(String name, String description, long minPrice) {
        if (name.isEmpty()||description.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (minPrice <= 0 ){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        list = new LinkedList<>();
    }

    public void addBid(Person person,long price) {
        if (person == null) {
            throw new NullPointerException();
        }
        if (price <= 0) {
            throw new IllegalArgumentException();
        }
        if (price < minPrice) {
            return;
        }
        if (!(highestBid == null)){
        if (price <= highestBid.getPrice()) {
            return;
        }
    }
        Bid bid = new Bid(person,price);
        if (list.isEmpty() || price >= minPrice) {
            highestBid = bid;
        }else {
            for (Bid bid2 :list){
                if (bid2.getPrice() < bid.getPrice()||price >=minPrice){
                    highestBid = bid;
                }
            }
        }
        list.add(bid);



    }

    public List<Bid> getAllBids(){
        return list;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }
    public Bid getHighestBid(){
        return highestBid;
    }

    public String toString(){
        return name + ": " + description + " (minimum bidding price: " + minPrice +" EUR)";
    }


}
