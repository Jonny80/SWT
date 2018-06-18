import java.util.*;

public class Team extends AbstractEnterpriseUnit {

    private StaffMember teamleader;

    public Team(String name,StaffMember teamleader) {

        super(name);
        if (name ==null||teamleader==null){
            throw new NullPointerException();
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.teamleader = teamleader;
    }

    public StaffMember getTeamLeader() {
        return teamleader;
    }

    @Override
    public String getName() {
        return teamleader.getName();
    }
    public List<StaffMember> getTeamMembers(){
        /*
        Set<StaffMember> list = new HashSet<>();
        for (StaffMember member : teamleader.getDirectSubordinates()){
            System.out.println(member + " " + member.getDirectSubordinates());
            list.addAll(member.getDirectSubordinates());
        }
        System.out.println("################################");
        List<StaffMember> list3 = new LinkedList<>();
        list3.addAll(list);
        for (StaffMember member1:list3){
            list.addAll(member1.getDirectSubordinates());
            System.out.println(member1 + "" + member1.getDirectSubordinates());
        }
        list.add(teamleader);
        list.addAll(teamleader.getDirectSubordinates());
        List<StaffMember> list2 = new LinkedList<>();
        list2.addAll(list);
        Collections.sort(list2);*/

        Set<StaffMember> set = new HashSet<>();
        List<StaffMember> sublist = new LinkedList<>();
        sublist.addAll(teamleader.getDirectSubordinates());
        set.addAll(teamleader.getDirectSubordinates());
        set.add(teamleader);
        while(!sublist.isEmpty()){
            List<StaffMember> between = new LinkedList<>();
            for (StaffMember member : sublist){
                between.addAll(member.getDirectSubordinates());
            }
            set.addAll(between);
            sublist = between;

        }
        sublist.clear();
        sublist.addAll(set);
        Collections.sort(sublist);

        return sublist;
    }
}
