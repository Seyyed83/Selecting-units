import java.util.Scanner;

public abstract class Course {
    static Scanner scanner = new Scanner(System.in);
            private boolean constructor = true;
    int code, capacity, fullCapacity, unit;
    String name, teacherName, time, midTest, finalTest;
        double timeFrom, timeUntil, midFrom, midUntil, finalFrom, finalUntil, midDate, finalDate;
        String timeDay;

    public Course(int code, int capacity, int fullCapacity, int unit, String name, String teacherName, String time, String midTest, String finalTest) {
        this.code = code;
        this.capacity = capacity;
        this.fullCapacity = fullCapacity;
        this.unit = unit;
        this.name = name;
        this.teacherName = teacherName;
        this.time = time;
        this.midTest = midTest;
        this.finalTest = finalTest;
        if (midTest == "---") {
            this.midTest += "              ";
        }
        if (finalTest == "---") {
            this.finalTest += "              ";
        }
    }
}
