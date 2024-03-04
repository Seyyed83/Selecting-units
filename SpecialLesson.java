import java.util.ArrayList;

public class SpecialLesson extends Course {
    ArrayList<Student> students=new ArrayList<>();
    public SpecialLesson(int code, int capacity, int fullCapacity, int unit, String name, String teacherName, String time, String midTest, String finalTest, College college) {
        super(code, capacity, fullCapacity, unit, name, teacherName, time, midTest, finalTest,college);
    }
}
