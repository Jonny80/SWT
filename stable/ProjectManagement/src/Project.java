import java.util.*;

public class Project {

    private String name;
    private String description;
    private Task task;

    public Project(String name, String description, double rate) {
        if (name.isEmpty() || description.isEmpty()|| rate<0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.description = description;
    }

    public void setTask(Task task) {
        if (task == null){
            throw new NullPointerException();
        }
        this.task = task;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {
        return description;
    }
    public double getDuration(){
        double duration = 0;
        for (Deliverable deliverable : task.allDeliverables()){
            duration=duration+deliverable.getTimeRequired();
        }
        return duration;
    }
    public long getTotalCost(){
        return task.getCostEstimate();
    }
    public Map<Calendar,List<Deliverable>> allDeliverables(){
        Map<Calendar,List<Deliverable>> map = new HashMap<>();
        for (Deliverable deliverable : task.allDeliverables()){
            if (map.containsKey(deliverable.getDate())){
                List<Deliverable> list = map.get(deliverable.getDate());
                list.add(deliverable);
                map.replace(deliverable.getDate(),list);
            }else {
                List<Deliverable> deliverables = new LinkedList<>();
                deliverables.add(deliverable);
                map.put(deliverable.getDate(),deliverables);
            }
        }
        return map;
    }
}