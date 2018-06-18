import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StaffMember implements EnterpriseNode,Comparable {
    private String name;
    private String job;
    private List<StaffMember> directSubordinates;

    public StaffMember(String name, String job) {
        if (name.isEmpty()||job.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (name == null|| job ==null){
            throw new NullPointerException();
        }
        this.name = name;
        this.job = job;
        directSubordinates = new LinkedList<StaffMember>();
    }

    public boolean addDirectSubordinate(StaffMember subordinate){
        if (subordinate == null){
            throw new NullPointerException();
        }
        if (directSubordinates.contains(subordinate)){
            return false;
        }
        directSubordinates.add(subordinate);
        return true;
    }

    public boolean removeDirectSubordinate(StaffMember subordinate){
        if (subordinate == null){
            throw new NullPointerException();
        }
        if (!directSubordinates.contains(subordinate)){
            return false;
        }
        directSubordinates.remove(subordinate);
        return true;
    }

    public String getJob() {
        return job;
    }

    public Set<StaffMember> getDirectSubordinates() {
        Set<StaffMember> set = new HashSet<>();
        set.addAll(directSubordinates);
        return set;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        StaffMember member = (StaffMember) o;
        return this.name.compareTo(member.getName());
    }
    public String toString(){
        return name;
    }
}
