import java.util.*;
/**
 * Created by jonny on 19.06.17.
 */
public class EventCatalogImpl implements EventCatalog {

    TreeMap<Event, Set<Time>> setTreeMap = new TreeMap<>();

    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tSet) {
        if (tSet == null || e == null){
            return false;
        }
        if (setTreeMap.containsKey(e)){
            return false;
        }
        setTreeMap.put(e,tSet);
        return true;
    }

    @Override
    public boolean addTimeToEvent(Event e, Time t) {
        if (e == null || t==null){
            throw new NullPointerException("");
        }
        if (map.containsKey(e) || map.get(e).contains(t)){
            return false;
        }else {
            map.get(e).add(t);
            return true;
        }
    }

    @Override
    public Set<Event> getAllEvents() {
        return map.keySet();
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        if (e == null){
            throw new NullPointerException("");
        }
        return map.get(e);
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        if (category == null){
            throw new NullPointerException("");
        }
        Map<Event, Set<Time>> a = new HashMap<>();
        for (Event e : map.keySet()) if (e.getCategory() == category) a.put(e,map.get(e));
        return a;
    }

    @Override
    public Set<Time> deleteEvent(Event e) {
        if (e == null){
            throw new NullPointerException("");
        }
        if (map.containsKey(e)){
            return map.get(e);
        }
        return null;
    }

    @Override
    public boolean deleteTime(Event e, Time t) {
        if (e == null || t == null){
            throw new NullPointerException("");
        }
        if (map.containsKey(e) && map.get(e).contains(t)){
            map.get(e).remove(t);
            return true;
        }
        return false;
    }
}
