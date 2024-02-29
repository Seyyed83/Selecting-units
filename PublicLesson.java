import java.util.ArrayList;

public class PublicLesson extends Course{
    ArrayList<Student> students=new ArrayList<>();
    public PublicLesson(int code, int capacity, int fullCapacity, int unit, String name, String teacherName, String time, String midTest, String finalTest) {
        super(code, capacity, fullCapacity, unit, name, teacherName, time, midTest, finalTest);
    }
}
