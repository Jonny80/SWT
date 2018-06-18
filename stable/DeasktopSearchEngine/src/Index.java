import java.util.*;

public class Index {
    private Map<String,List<Resource>> index;

    public Index() {
        index = new TreeMap<>();
    }

    public void add(Resource res) {
        System.out.println(res);
        if (res == null) {
            throw new NullPointerException();
        }
        Set<String> set = res.getType().getCollector().getKeywords(res);
        for(String s : set){
            if (!index.containsKey(s)) {
                index.put(s, new LinkedList<>());
                if (!index.get(s).contains(res)){
                    index.get(s).add(res);
                }
            }else {
                index.get(s).add(res);
            }
        }
        System.out.println(index);

    }

    public List<Resource> getResources(String keyword){
        if (keyword.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (!index.containsKey(keyword)){
            List<Resource> list = new LinkedList<>();
            return list;
        }
        return index.get(keyword);
    }
}
