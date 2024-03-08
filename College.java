import java.util.ArrayList;
import java.util.List;

public class College {
    String name;
    List<Course> courses=new ArrayList<>();
    public College(String name){
        this.name=name;
        University.colleges.add(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
