import java.util.LinkedList;
import java.util.List;

public abstract class Auction {
    private int nextItem = 1;
    private boolean closed = false;
    private List<Person> bidders;
    private List<Item> allItens;

    public Auction() {
        bidders = new LinkedList<>();
        allItens = new LinkedList<>();
    }

    public void addBid(String itemName,String nameOfBidder,long price){
        if (itemName.isEmpty()||nameOfBidder.isEmpty()||price <=0){
            throw new IllegalArgumentException();
        }
        Person person = new Person(nameOfBidder);
        Bid bid = new Bid(person,price);
        bidders.add(person);
        allItens.add()
    }



}
