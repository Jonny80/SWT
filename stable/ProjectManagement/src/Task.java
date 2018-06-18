import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task extends ProjectItem{

    private List<ProjectItem> piList = new LinkedList<>();

    public Task(String name, String details, double rate) {

        super(name, details, rate);
        if (name.isEmpty() || details.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (rate < 0){
            throw new IllegalArgumentException();
        }
    }





    @Override
    public double getTimeRequired() {
        double time = 0;
        for (Deliverable item : allDeliverables()) {
            time = time + item.getTimeRequired();
        }
        return time;
    }

    @Override
    public long getMaterialCost() {
        long cost = 0;
        for (ProjectItem item : allDeliverables()) {
            cost = cost + item.getMaterialCost();
        }
        return cost;
    }


    public List<Deliverable> allDeliverables(){
        List<Deliverable> liste = new ArrayList<>();
        for (ProjectItem item : piList) {
            if (item instanceof Deliverable) {
                liste.add((Deliverable) item);
            }
        }
        return liste;

    }

    public void removeProjectItem(ProjectItem projectItem){
        if (projectItem == null){
            throw new NullPointerException();
        }
        piList.remove(projectItem);
    }

    public void addProjectItem(ProjectItem pi){
        if (pi == null){
            throw new NullPointerException();
        }
        if (pi instanceof Deliverable){
            piList.add(pi);
            return;
        }
        if (pi instanceof Task){
            for (ProjectItem item : ((Task) pi).allDeliverables()){
                piList.add(item);
            }
            piList.add(pi);
            return;
        }

    }

}
