import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesktopSearch {
    private Map<String,ResourceType> types;
    private Index index;

    public DesktopSearch() {
        types = new HashMap<>();
        index = new Index();
    }

    public void registerType(String extension, ResourceType type){
        types.put(extension,type);
    }



    public ResourceType getType(String extension){
        if (extension == null){
            return null;
        }

        return types.get(extension);
    }

    public void unregisterType(String extension){
        if (extension.isEmpty()){
            throw new NullPointerException();
        }

        types.remove(extension);
    }

    public void registerResource(Resource res){
        if (res == null){
            return;
        }
        index.add(res);

    }


    public List<Resource> processRequest(String request){
        return index.getResources(request);


    }
}
