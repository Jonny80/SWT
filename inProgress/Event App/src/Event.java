/**
 * Created by jonny on 19.06.17.
 */
public class Event implements java.lang.Comparable<Event> {
    private String title;
    private EventCategory category;

    Event(String title,EventCategory category){
        if (title.isEmpty()){
            throw new IllegalArgumentException("");
        }
        if (title == null || category == null){
            throw new NullPointerException("");
        }
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public EventCategory getCategory() {
        return category;
    }

    @Override
    public int compareTo(Event o) {
        if (o == null || this == null){
            throw new NullPointerException("");
        }
        if (o.getTitle().length()< this.getTitle().length()){
            return 1;

        }
        if (o.getTitle().length()== this.getTitle().length()){
            if (o.getCategory().toString().length() < this.getCategory().toString().length()){
                return 1;
            }if (o.getCategory().toString().length() == this.getCategory().toString().length()){
                return 0;
            }if (o.getCategory().toString().length() > this.getCategory().toString().length()){
                return -1;
            }
        }
        if (o.getTitle().length() > this.getTitle().length()){
            return -2;
        }
        else {
            return 1;
        }
    }
}
