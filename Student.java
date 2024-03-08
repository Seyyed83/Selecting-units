import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    public static Map<Integer, Student> username2student = new HashMap<>();
    ArrayList<Course> studentCourses = new ArrayList<>();
    Integer userName, password;
    int unitTotalCapacity, unitPublicCapacity;
    String name;

    public Student(Integer userName, Integer password, String name) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        username2student.put(userName, this);
        University.totalStudents.put(userName,this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null){
            return false;
        }
        if (!(obj instanceof Student)){
            return false;
        }
        return userName.equals(((Student) obj).userName);
    }

    @Override
    public String toString(){
        return name;
    }
}
