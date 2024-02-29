import java.util.Scanner;

public class CLI {
    Scanner scanner =new Scanner(System.in);
    String input;

    public static String Specification(Course course) {
        if (course == null) {
            return "";
        }
        String str = course.code + "  " + course.name;
        if (course.name.length() <= 25) {
            for (int i = 0; i < 25 - course.name.length(); i++) {
                str += " ";
            }
        }
        str = str + "  " + course.teacherName;
        if (course.teacherName.length() <= 25) {
            for (int i = 0; i < 25 - course.teacherName.length(); i++) {
                str += " ";
            }
        }
        str = str + "     " + course.fullCapacity + "/" + course.capacity;
        if ((course.fullCapacity + "/" + course.capacity).length() <= 7) {
            for (int i = 0; i < 7 - (course.fullCapacity + "/" + course.capacity).length(); i++) {
                str += " ";
            }
        }
        str = str + "     " + course.time + "     " + course.midTest + "     " + course.finalTest + "     " + course.unit + "     ";
        if (course instanceof SpecialLesson) {
            str += "Special";
        }
        if (course instanceof PublicLesson) {
            str += "Public";
        }
        return str;
    }
}
