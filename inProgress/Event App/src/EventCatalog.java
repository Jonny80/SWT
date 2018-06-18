import java.util.*;

/**
 * Created by jonny on 19.06.17.
 */
public interface EventCatalog {
    TreeMap<Event,Set<Time>> map = new TreeMap<>();
    boolean addCatalogEntry(Event e, Set<Time> tSet);
    boolean addTimeToEvent(Event e,Time t);
    Set<Event> getAllEvents();
    Set<Time> getTimesOfEvent(Event e);
    Map<Event,Set<Time>> filterByEventCategory(EventCategory category);
    Set<Time> deleteEvent(Event e);
    boolean deleteTime(Event e,Time t);
}
