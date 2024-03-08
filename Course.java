import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Course {
    public static HashMap<Integer, Integer> totalCourses = new HashMap<>();
    ArrayList<Student> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int code, capacity, fullCapacity, unit;
    String name, teacherName, time, midTest, finalTest;
    double timeFrom, timeUntil, midFrom, midUntil, finalFrom, finalUntil, midDate, finalDate;
    String timeDay;
    College college;

    public Course(int code, int capacity, int fullCapacity, int unit, String name, String teacherName, String time, String midTest, String finalTest, College college) {
        boolean constructor = true;
        while (constructor) {
            constructor = false;
            try {
                for (int i=0;i<time.length();i++){
                    if (time.charAt(i)==' '){
                        throw new RuntimeException();
                    }
                }
                if (time.length() != 19) {
                    throw new RuntimeException();
                }
                if (!(time.charAt(0) > 47 && time.charAt(0) < 51) || !(time.charAt(1) > 47 && time.charAt(1) < 58) || time.charAt(2) != '.' || !(time.charAt(3) > 47 && time.charAt(3) < 54) || !(time.charAt(4) > 47 && time.charAt(4) < 58)) {
                    System.out.println("From what time !!! (time)");
                    System.out.println("Please try again : ");
                    time = scanner.next();
                    constructor = true;
                    continue;
                } else {
                    timeFrom = time.charAt(0) - 48;
                    timeFrom *= 10;
                    timeFrom += time.charAt(1) - 48;
                    double t = (double) time.charAt(3) - 48;
                    t *= 10;
                    t += time.charAt(4) - 48;
                    timeFrom += t / 100;
                    if (timeFrom >= 24) {
                        System.out.println("Can't start from : " + timeFrom + " (time)");
                        System.out.println("Please try again : ");
                        time = scanner.next();
                        constructor = true;
                        continue;
                    }
                }
                if (!(time.charAt(6) > 47 && time.charAt(6) < 51) || !(time.charAt(7) > 47 && time.charAt(7) < 58) || time.charAt(8) != '.' || !(time.charAt(9) > 47 && time.charAt(9) < 54) || !(time.charAt(10) > 47 && time.charAt(10) < 58)) {
                    System.out.println("Until what !!! (time)");
                    System.out.println("Please try again:");
                    time = scanner.next();
                    constructor = true;
                    continue;
                } else {
                    timeUntil = time.charAt(6) - 48;
                    timeUntil *= 10;
                    timeUntil += time.charAt(7) - 48;
                    double t = (double) time.charAt(9) - 48;
                    t *= 10;
                    t += time.charAt(10) - 48;
                    timeUntil += t / 100;
                    if (timeUntil >= 24) {
                        System.out.println("Can't end until : " + timeUntil + " (time)");
                        System.out.println("Please try again : ");
                        time = scanner.next();
                        constructor = true;
                        continue;
                    }
                }
                if (!(time.startsWith("Son", 12) || time.startsWith("Mon", 12) || time.startsWith("Tue", 12) || time.startsWith("Wen", 12) || time.startsWith("Thu", 12) || time.startsWith("Fri", 12) || time.startsWith("Sat", 12))) {
                    System.out.println("What day ??? (time)");
                    System.out.println("Please try again:");
                    time = scanner.next();
                    constructor = true;
                    if (!(time.startsWith("Son", 16) || time.startsWith("Mon", 16) || time.startsWith("Tue", 16) || time.startsWith("Wen", 16) || time.startsWith("Thu", 16) || time.startsWith("Fri", 16) || time.startsWith("Sat", 16) || time.startsWith("---", 16))) {
                        System.out.println("What day ??? (time)");
                        System.out.println("Please try again:");
                        time = scanner.next();
                        continue;
                    }
                    continue;
                } else {
                    timeDay = time.substring(12);
                }
            } catch (Exception e) {
                System.out.println("UnExcepted time input (time)");
                System.out.println("Please try again : ");
                time = scanner.next();
                constructor = true;
                continue;
            }
            try {
                for (int i=0;i<midTest.length();i++){
                    if (midTest.charAt(i)==' '){
                        throw new RuntimeException();
                    }
                }
                if (midTest.length() != 17&&!midTest.equals("---")) {
                    throw new RuntimeException();
                }
                if (midTest.equals("---")) {
                    midDate = 0;
                    midFrom = 0;
                    midUntil = 0;
                } else {
                    if (!(midTest.charAt(0) > 47 && midTest.charAt(0) < 51) || !(midTest.charAt(1) > 47 && midTest.charAt(1) < 58) || midTest.charAt(2) != '.' || !(midTest.charAt(3) > 47 && midTest.charAt(3) < 54) || !(midTest.charAt(4) > 47 && midTest.charAt(4) < 58)) {
                        System.out.println("From what time !!! (midTime)");
                        System.out.println("Please try again : ");
                        midTest = scanner.next();
                        constructor = true;
                        continue;
                    } else {
                        midFrom = midTest.charAt(0) - 48;
                        midFrom *= 10;
                        midFrom += midTest.charAt(1) - 48;
                        double t = (double) midTest.charAt(3) - 48;
                        t *= 10;
                        t += midTest.charAt(4) - 48;
                        midFrom += t / 100;
                        if (midFrom >= 24) {
                            System.out.println("Can't start from : " + midFrom + " (midTime)");
                            System.out.println("Please try again:");
                            midTest = scanner.next();
                            constructor = true;
                            continue;
                        }
                    }
                    if (!(midTest.charAt(6) > 47 && midTest.charAt(6) < 51) || !(midTest.charAt(7) > 47 && midTest.charAt(7) < 58) || midTest.charAt(8) != '.' || !(midTest.charAt(9) > 47 && midTest.charAt(9) < 54) || !(midTest.charAt(10) > 47 && midTest.charAt(10) < 58)) {
                        System.out.println("Until what time (midTest) !!!");
                        System.out.println("Please try again:");
                        midTest = scanner.next();
                        constructor = true;
                        continue;
                    } else {
                        midUntil = midTest.charAt(6) - 48;
                        midUntil *= 10;
                        midUntil += midTest.charAt(7) - 48;
                        double t = (double) midTest.charAt(9) - 48;
                        t *= 10;
                        t += midTest.charAt(10) - 48;
                        midUntil += t / 100;
                        if (midUntil >= 24) {
                            System.out.println("Can't end until : " + midUntil + " (midTime)");
                            System.out.println("Please try again : ");
                            midTest = scanner.next();
                            constructor = true;
                            continue;
                        }
                    }
                    if (!(midTest.charAt(12) > 47 && midTest.charAt(12) < 50) || !(midTest.charAt(13) > 47 && midTest.charAt(13) < 58) || midTest.charAt(14) != '.' || !(midTest.charAt(15) > 47 && midTest.charAt(15) < 52) || !(midTest.charAt(16) > 47 && midTest.charAt(16) < 58)) {
                        System.out.println("On what Date !!! (midTest)");
                        System.out.println("Please try again : ");
                        midTest = scanner.next();
                        constructor = true;
                        continue;
                    } else {
                        midDate = midTest.charAt(12) - 48;
                        midDate *= 10;
                        midDate += midTest.charAt(13) - 48;
                        double t = (double) midTest.charAt(15) - 48;
                        t *= 10;
                        t += midTest.charAt(16) - 48;
                        midDate += (t / 100);
                        if ((midDate - ((int) midDate / 1) > 0.3) && !(midDate == 01.31 || midDate == 02.31 || midDate == 03.31 || midDate == 04.31 || midDate == 05.31 || midDate == 06.31)) {
                            System.out.println("Can't be on : " + midDate + " midTest");
                            System.out.println("Please try again : ");
                            midTest = scanner.next();
                            constructor = true;
                            continue;
                        }
                        if (midDate >= 12.31) {
                            System.out.println("Can't be on : " + midDate + " midTest");
                            System.out.println("Please try again : ");
                            midTest = scanner.next();
                            constructor = true;
                            continue;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("UnExcepted midTime input (midTime)");
                System.out.println("Please try again:");
                midTest = scanner.next();
                constructor = true;
                continue;
            }
            try {
                for (int i=0;i<finalTest.length();i++){
                    if (finalTest.charAt(i)==' '){
                        throw new RuntimeException();
                    }
                }
                if (finalTest.length() != 17 && !finalTest.equals("---")) {
                    throw new RuntimeException();
                }
                if (finalTest.equals("---")) {
                    finalDate = 0;
                    finalFrom = 0;
                    finalUntil = 0;
                } else {
                    if (!(finalTest.charAt(0) > 47 && finalTest.charAt(0) < 51) || !(finalTest.charAt(1) > 47 && finalTest.charAt(1) < 58) || finalTest.charAt(2) != '.' || !(finalTest.charAt(3) > 47 && finalTest.charAt(3) < 54) || !(finalTest.charAt(4) > 47 && finalTest.charAt(4) < 58)) {
                        System.out.println("From what time !!! (finalTest)");
                        System.out.println("Please try again : ");
                        finalTest = scanner.next();
                        constructor = true;
                        continue;
                    } else {
                        finalFrom = finalTest.charAt(0) - 48;
                        finalFrom *= 10;
                        finalFrom += finalTest.charAt(1) - 48;
                        double t = (double) finalTest.charAt(3) - 48;
                        t *= 10;
                        t += finalTest.charAt(4) - 48;
                        finalFrom += t / 100;
                        if (finalFrom >= 24) {
                            System.out.println("Can't start from : " + finalFrom + "  (finalTest)");
                            System.out.println("Please try again : ");
                            finalTest = scanner.next();
                            constructor = true;
                            continue;
                        }
                    }
                    if (!(finalTest.charAt(6) > 47 && finalTest.charAt(6) < 51) || !(finalTest.charAt(7) > 47 && finalTest.charAt(7) < 58) || finalTest.charAt(8) != '.' || !(finalTest.charAt(9) > 47 && finalTest.charAt(9) < 54) || !(finalTest.charAt(10) > 47 && finalTest.charAt(10) < 58)) {
                        System.out.println("Until what time !!! (finalTest)");
                        System.out.println("Please try again:");
                        finalTest = scanner.next();
                        constructor = true;
                        continue;
                    } else {
                        finalUntil = finalTest.charAt(6) - 48;
                        finalUntil *= 10;
                        finalUntil += finalTest.charAt(7) - 48;
                        double t = (double) finalTest.charAt(9) - 48;
                        t *= 10;
                        t += finalTest.charAt(10) - 48;
                        finalUntil += t / 100;
                        if (finalUntil >= 24) {
                            System.out.println("Can't end until : " + finalUntil + " (finalTest)");
                            System.out.println("Please try again : ");
                            finalTest = scanner.next();
                            constructor = true;
                            continue;
                        }
                    }
                    if (!(finalTest.charAt(12) > 47 && finalTest.charAt(12) < 50) || !(finalTest.charAt(13) > 47 && finalTest.charAt(13) < 58) || finalTest.charAt(14) != '.' || !(finalTest.charAt(15) > 47 && finalTest.charAt(15) < 52) || !(finalTest.charAt(16) > 47 && finalTest.charAt(16) < 58)) {
                        System.out.println("On what day !!! (finalTest)");
                        System.out.println("Please try again : ");
                        finalTest = scanner.next();
                        constructor = true;
                    } else {
                        finalDate = finalTest.charAt(12) - 48;
                        finalDate *= 10;
                        finalDate += finalTest.charAt(13) - 48;
                        double t = (double) finalTest.charAt(15) - 48;
                        t *= 10;
                        t += finalTest.charAt(16) - 48;
                        finalDate += t / 100;
                        if ((finalDate - ((int) finalDate / 1) > 0.3) && !(finalDate == 01.31 || finalDate == 02.31 || finalDate == 03.31 || finalDate == 04.31 || finalDate == 05.31 || finalDate == 06.31)) {
                            System.out.println("Can't be on : " + finalDate + " finalDate");
                            System.out.println("Please try again : ");
                            finalTest = scanner.next();
                            constructor = true;
                            continue;
                        }
                        if (finalDate >= 12.31) {
                            System.out.println("Can't be on : " + finalDate + " (finalTest)");
                            System.out.println("Please try again:");
                            midTest = scanner.next();
                            constructor = true;
                        }
                    }
                }
            } catch (Exception e) {
                if (finalTest != null) {
                    System.out.println("UnExcepted finalTime input (finalTest)");
                    System.out.println("Please try again:");
                    finalTest = scanner.next();
                    constructor = true;
                }
            }
        }
        this.code = code;
        this.capacity = capacity;
        this.fullCapacity = fullCapacity;
        this.unit = unit;
        this.name = name;
        this.teacherName = teacherName;
        this.time = time;
        this.midTest = midTest;
        this.finalTest = finalTest;
        college.courses.add(this);
        if (midTest.equals("---")) {
            this.midTest += "              ";
        }
        if (finalTest.equals("---")) {
            this.finalTest += "              ";
        }
        this.college = college;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Course)) {
            return false;
        }
        if (((Course) obj).code == code && ((Course) obj).name.equals(name) && ((Course) obj).teacherName.equals(teacherName)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return code + " " + name;
    }
}
