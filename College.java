import java.util.ArrayList;

public class College {
    String name;
    ArrayList<Course> courses=new ArrayList<>();
    public College(String name){
        this.name=name;
        University.colleges.add(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
