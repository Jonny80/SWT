import java.util.ArrayList;
import java.util.List;

public class Adapter implements IProject {

    private Task task;

    private String name;
    private String details;

    public Adapter(String name, String details, double rate) {

        this.name = name;
        this.details = details;
        if (name == null || details == null){
            throw new NullPointerException();
        }
        if (rate < 0 || name.isEmpty() || details.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void setTask(Task newTask) {
        if (newTask == null){
            throw new NullPointerException();
        }
        this.task = newTask;

    }

    @Override
    public double getDuration() {
        double duration = 0;
        for (Deliverable deliverable : getDeliverables()){
            duration = duration + deliverable.getTimeRequired();
        }
        return duration;
    }

    @Override
    public long getTotalCost() {
        long cost = 0;
        long durationcost = 0;
        for (Deliverable deliverable : getDeliverables()){
            durationcost = (long) (durationcost + deliverable.getTimeRequired()*task.getRate());
        }
        System.out.println(task.getMaterialCost());
        System.out.println(durationcost);
        cost = task.getMaterialCost() + durationcost;
        return cost;
    }

    @Override
    public List<Deliverable> getDeliverables() {
       return task.allDeliverables();
    }
}
