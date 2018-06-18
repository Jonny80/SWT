import java.util.HashSet;
import java.util.Set;

public class DefaultCollector implements KeywordCollector {
    @Override
    public Set<String> getKeywords(Resource res) {
        Set<String> set = new HashSet<>();
        String[] list = res.getName().split(" ");
        for(int i=0;i<=list.length;i++){
            set.add(list[i]);
        }
        return set;
    }
}
