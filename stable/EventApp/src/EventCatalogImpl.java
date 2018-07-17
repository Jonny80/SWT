
import java.util.*;

public class EventCatalogImpl extends java.util.TreeMap<Event,Set<Time>> implements EventCatalog {

    private TreeMap<Event,Set<Time>> map;

    public EventCatalogImpl() {
        this.map = new TreeMap<>();
    }


    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tset) {
        if (e == null || tset == null){
            throw new NullPointerException();
        }
        for (Time t : tset){
            if (t==null){
                throw new NullPointerException();
            }
        }
        if (map.containsKey(e)){
            return false;
        }else {
            map.put(e,tset);
            return true;
        }
    }

    @Override
    public boolean addTimeToEvent(Event e, Time t) {
        if (e == null || t == null)
        {
            throw new NullPointerException();
        }
        if (!map.containsKey(e)){
            return false;
        }
        Set<Time> set = map.get(e);
        if (set.contains(t)){
            return false;
        }
        set.add(t);
        map.replace(e,set);
        return true;
    }

    @Override
    public Set<Event> getAllEvents() {
        return map.keySet();
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        if (e ==null){
            throw new NullPointerException();
        }
        return map.get(e);
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        if (category == null){
            throw new NullPointerException();
        }
        Map<Event,Set<Time>> map2 = new TreeMap<>();
        for (Event e : map.keySet()){
            if (e.getCategory() == category){
                map2.put(e,map.get(e));
            }
        }
        return map2;
    }

    @Override
    public Set<Time> deleteEvent(Event e) {
        if (e == null){
            throw new NullPointerException();
        }
        if (!map.containsKey(e)){
            return null;
        }
        return map.remove(e);

    }

    @Override
    public boolean deleteTime(Event e, Time t) {
        if (e == null || t == null){
            throw new NullPointerException();
        }

        if (!map.containsKey(e)){
            return false;
        }

        Set<Time> set = map.get(e);
        if (!set.contains(t)){
            return false;
        }
        set.remove(t);
        map.replace(e,set);
        return true;



    }
}
