import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student {
    public static Map<Integer, Student> username2student = new HashMap<>();
    ArrayList<Course> studentCourses = new ArrayList<>();
    Integer userName, password;
    int unitTotalCapacity, unitPublicCapacity;
    String name;
    Scanner scanner = new Scanner(System.in);

    public Student(Integer userName, Integer password, String name) {
        in:
        while (true) {
            for (Integer i : University.totalStudents.keySet()) {
                if (userName == i ||userName<0) {
                    System.out.println("Repeated UserName or also unexpected (".concat(name).concat(")"));
                    System.out.println("Please try again : ");
                    String inp = scanner.next();
                    userName = 0;
                    for (int j = 0; j < inp.length(); j++) {
                        if (inp.charAt(j) > 47 && inp.charAt(j) < 58) {
                            userName += inp.charAt(j) - 48;
                            userName *= 10;
                        } else {
                            userName=-1;
                            continue in;
                        }
                    }
                    userName /= 10;
                    continue in;
                }
            }
            break;
        }
        this.userName = userName;
        this.password = password;
        this.name = name;
        username2student.put(userName, this);
        University.totalStudents.put(userName, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        return userName.equals(((Student) obj).userName);
    }

    @Override
    public String toString() {
        return name;
    }
}
