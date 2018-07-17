public class Event implements Comparable<Event> {

    private String title;
    private EventCategory category;

    public Event(String title,EventCategory category) {
        if (category==null|| title==null){
            throw new NullPointerException();
        }
        if (title.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.category = category;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public EventCategory getCategory() {
        return category;
    }

    @Override
    public int compareTo(Event o) {
        if (o == null){
            throw new NullPointerException();
        }
        int result = this.getTitle().compareTo(o.getTitle());
        if (result == 0){
            return this.getCategory().toString().compareTo(o.getCategory().toString());
        }
        return this.getTitle().compareTo(o.getTitle());
    }
}
