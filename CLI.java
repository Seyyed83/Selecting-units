import java.util.Scanner;

public class CLI {
    Scanner scanner = new Scanner(System.in);
    String input;

    public static String Specification(Course course) {
        if (course == null) {
            return "";
        }
        StringBuilder str = new StringBuilder(course.code + "  " + course.name);
        if (course.name.length() <= 25) {
            str.append(" ".repeat(25 - course.name.length()));
        }
        str.append("  ").append(course.teacherName);
        if (course.teacherName.length() <= 25) {
            str.append(" ".repeat(25 - course.teacherName.length()));
        }
        str.append("   ").append(course.fullCapacity).append("/").append(course.capacity);
        if ((course.fullCapacity + "/" + course.capacity).length() <= 7) {
            str.append(" ".repeat(Math.max(0, 7 - (course.fullCapacity + "/" + course.capacity).length())));
        }
        str.append("     ").append(course.time).append("     ").append(course.midTest).append("      ").append(course.finalTest).append("          ").append(course.unit).append("       ");
        if (course instanceof SpecialLesson) {
            str.append("Special");
        }
        if (course instanceof PublicLesson) {
            str.append("Public");
        }
        return str.toString();
    }

    private void exitORenter(String str) {
        if (str.equals("ex")) {
            System.out.println("Have a good time");
            return;
        }
        if (str.equals("en")) {
            Enter();
        }
    }

    public void Enter() {
        System.out.println("Please choose one of these ");
        System.out.println("1- Log in as Student         ");
        System.out.println("2- Log in as Admin           ");
        System.out.println("3- Sign up or change password");
        System.out.println("ex- Exit                     ");
        System.out.println();
        input = scanner.next();
        exitORenter(input);
        switch (input) {
            case ("1"):
                System.out.println("Please tell me your username : ");
                System.out.println();
                studentUsername();
            case ("2"):
                System.out.println("Please tell me your username : ");
                System.out.println();
                //AdminUsername();
            case ("3"):
                //TODO
            case ("ex"):
                System.exit(0);
            default:
                if (!input.equals("en")) {
                    System.out.println("unExpected enter ");
                }
                Enter();
        }
    }

    private void studentUsername() {
        try {
            String str = scanner.next();
            int user = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > 47 && str.charAt(i) < 58) {
                    user += str.charAt(i) - 48;
                    user *= 10;
                } else {
                    throw new RuntimeException();
                }
            }
            user /= 10;
            if (Student.username2student.containsKey(user)) {
                System.out.println("Please tell me your password : ");
                System.out.println();
                studentPassword(user);
            } else {
                System.out.println("There is no Student by this username");
                System.out.println("Please choose one of these          ");
                System.out.println("1- try again :                      ");
                System.out.println("en- go Enter page                   ");
                System.out.println("ex- Exit                            ");
                System.out.println();
                input = scanner.next();
                exitORenter(input);
                switch (input) {
                    case ("1"):
                        System.out.println("Please tell me your username : ");
                        System.out.println();
                        studentUsername();
                    case ("en"):
                        Enter();
                        return;
                    case ("ex"):
                        System.exit(0);
                    default:
                        System.out.println("unExpected choice      " + input);
                        System.out.println("Please try again for username : ");
                        System.out.println();
                        studentUsername();
                }
            }
        } catch (Exception e) {
            System.out.println("unExpected username");
            System.out.println("Please try again : ");
            System.out.println();
            studentUsername();
        }
    }

    private void studentPassword(Integer user) {
        try {
            String str = scanner.next();
            Integer pass = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > 47 && str.charAt(i) < 58) {
                    pass += str.charAt(i) - 48;
                    pass *= 10;
                } else {
                    throw new RuntimeException();
                }
            }
            pass /= 10;
            if (pass.equals(Student.username2student.get(user).password)) {
                System.out.print("You enter successfully " + Student.username2student.get(user).name + " \n    Now ");
                Register(user);
            } else {
                System.out.println("    Wrong password !!!          ");
                System.out.println("    Please choose one of these  ");
                System.out.println("1-  Try again for password :    ");
                System.out.println("b-  Go back                     ");
                System.out.println("en- Go Enter page               ");
                System.out.println("ex- Exit                        ");
                System.out.println();
                input = scanner.next();
                exitORenter(input);
                switch (input) {
                    case ("1"):
                        System.out.println("Please tell me your password : ");
                        System.out.println();
                        studentPassword(user);
                    case ("b"):
                        System.out.println("Please tell me your username : ");
                        System.out.println();
                        studentUsername();
                    case ("en"):
                        Enter();
                        return;
                    case ("ex"):
                        System.exit(0);
                    default:
                        System.out.println("unExpected choice for " + input);
                        System.out.println("Please try again for password : ");
                        System.out.println();
                        studentPassword(user);
                }
            }
        } catch (Exception e) {
            System.out.println("UnExpected password");
            System.out.println("Please try again : ");
            studentPassword(user);
        }
    }

    private void Register(Integer user) {
        System.out.println("How can I help?");
        System.out.println("1-  Registered courses     ");
        System.out.println("2-  Presentation lessons   ");
        System.out.println("3-  Go to another account  ");
        System.out.println("en- Go Enter page          ");
        System.out.println("ex- Exit                   ");
        System.out.println();
        input = scanner.next();
        exitORenter(input);
        switch (input) {
            case ("1"):
                System.out.println("Code#Course name         #       Teacher name         #   FullyCap/Cap   #      Time       #         MidTest       #        FinalTest       #   Unit   #  S or P   ");
                for (Course cou : Student.username2student.get(user).studentCourses) {
                    System.out.println(Specification(cou));
                }
                if (Student.username2student.get(user).studentCourses.isEmpty()) {
                    System.out.println("Your list is Empty");
                }
                System.out.println();
                System.out.println("    Which one do you want ?     ");
                System.out.println("d - Delete course page          ");
                System.out.println("b - Go back                     ");
                System.out.println("en- Go Enter page               ");
                System.out.println("ex- Exit                        ");
                System.out.println();
                String input1 = scanner.next();
                exitORenter(input1);
                switch (input1) {
                    case ("b"):
                        Register(user);
                    case ("d"):
                        System.out.println("choose your course");
                        DeleteCourse(user);
                    case ("en"):
                        Enter();
                        return;
                    case ("ex"):
                        System.exit(0);
                    default:
                        System.out.println("unExpected choice for     " + input1);
                        System.out.println("Let's go to Register page ");
                        System.out.println();
                        Register(user);
                }
            case ("2"):
                Presentation(user);
            case ("3"):
                System.out.println("Please tell me your username : ");
                System.out.println();
                studentUsername();
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                System.out.println("UnExpected answer  ");
                System.out.println("Please try again : ");
                Register(user);
        }
    }

    private void Presentation(Integer user) {
        System.out.println("Your unitTotalCapacity : " + Student.username2student.get(user).unitTotalCapacity + "    Your unitPublicCapacity : " + Student.username2student.get(user).unitPublicCapacity);
        System.out.println("Choose your College : ");
        System.out.println();
        for (int i = 0; i < University.colleges.size(); i++) {
            System.out.println(i + "-  " + University.colleges.get(i));
        }
        System.out.println("b - Go back       ");
        System.out.println("en- Go Enter page ");
        System.out.println("ex- Exit          ");
        System.out.println();
        String input2 = scanner.next();
        exitORenter(input2);
        in:
        switch (input2) {
            case ("b"):
                Register(user);
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                int input3 = 0;
                for (int j = 0; j < input2.length(); j++) {
                    if (!(input2.charAt(j) > 47 && input2.charAt(j) < 58)) {
                        System.out.println("UnExpected answer  ");
                        System.out.println("Please try again : ");
                        System.out.println();
                        Presentation(user);
                        break in;
                    } else {
                        input3 += input2.charAt(j) - 48;
                        input3 *= 10;
                    }
                }
                input3 /= 10;
                if (input3 < University.colleges.size()) {
                    SelectUnit(user, input3);
                } else {
                    System.out.println("No college by this code");
                    System.out.println();
                    Presentation(user);
                }
        }
    }

    private void SelectUnit(Integer user, Integer intCollege) {
        System.out.println("Your unitTotalCapacity : " + Student.username2student.get(user).unitTotalCapacity + "    Your unitPublicCapacity : " + Student.username2student.get(user).unitPublicCapacity);
        System.out.println("Choose your Course : ");
        Course.totalCourses.clear();
        System.out.println("Code#Course name         #       Teacher name         #   FullyCap/Cap   #      Time       #         MidTest       #        FinalTest       #   Unit   #  S or P   ");
        for (int k = 0; k < University.colleges.get(intCollege).courses.size(); k++) {
            System.out.println(Specification(University.colleges.get(intCollege).courses.get(k)));
            Course.totalCourses.put(University.colleges.get(intCollege).courses.get(k).code, k);
        }
        if (University.colleges.isEmpty()) {
            System.out.println("College list is Empty");
        }
        System.out.println("b - Go back       ");
        System.out.println("en- Go Enter page ");
        System.out.println("ex- Exit          ");
        System.out.println();
        String input1 = scanner.next();
        exitORenter(input1);
        in:
        switch (input1) {
            case ("b"):
                Presentation(user);
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                int input2 = 0;
                for (int j = 0; j < input1.length(); j++) {
                    if (!(input1.charAt(j) > 47 && input1.charAt(j) < 58)) {
                        System.out.println("UnExpected answer  ");
                        System.out.println("Please try again : ");
                        System.out.println();
                        SelectUnit(user, intCollege);
                        break in;
                    } else {
                        input2 += input1.charAt(j) - 48;
                        input2 *= 10;
                    }
                }
                input2 /= 10;
                if (Course.totalCourses.containsKey(input2)) {
                    Permission(user, intCollege, Course.totalCourses.get(input2));
                } else {
                    System.out.println("No course by this code");
                    System.out.println();
                    SelectUnit(user, intCollege);
                }
        }
    }

    private void Permission(Integer user, Integer intCollege, Integer intCourse) {
        boolean nextPermission = true;
        if (University.colleges.get(intCollege).courses.get(intCourse).fullCapacity >= University.colleges.get(intCollege).courses.get(intCourse).capacity) {
            System.out.println();
            System.out.println("No capacity");
            System.out.println();
            nextPermission = false;
        }
        if (Student.username2student.get(user).unitTotalCapacity + University.colleges.get(intCollege).courses.get(intCourse).unit > 20) {
            System.out.println();
            System.out.println("You can't select more than 20 units");
            System.out.println();
            nextPermission = false;
        }
        if (University.colleges.get(intCollege).courses.get(intCourse) instanceof PublicLesson) {
            if (Student.username2student.get(user).unitPublicCapacity + University.colleges.get(intCollege).courses.get(intCourse).unit > 5) {
                System.out.println();
                System.out.println("You can't select more than 5 public units");
                System.out.println();
                nextPermission = false;
            }
        }
        for (Course cou : Student.username2student.get(user).studentCourses) {
            if ((cou.name).equals(University.colleges.get(intCollege).courses.get(intCourse).name)) {
                System.out.println();
                System.out.println("You got it before");
                System.out.println();
                nextPermission = false;
                break;
            }
            if (Interference(University.colleges.get(intCollege).courses.get(intCourse), cou)) {
                nextPermission = false;
                break;
            }
        }
        if (nextPermission) {
            AddStudent(user, intCollege, intCourse);
        } else {
            SelectUnit(user, intCollege);
        }
    }

    private boolean Interference(Course course1, Course course2) {
        if (((course1.timeFrom < course2.timeUntil && course1.timeFrom > course2.timeFrom) || (course1.timeUntil < course2.timeUntil && course1.timeUntil > course2.timeFrom)) && ((course1.timeDay.substring(0, 3).equals(course2.timeDay.substring(0, 3))) || course1.timeDay.substring(4).equals(course2.timeDay.substring(4)) || (course1.timeDay.substring(0, 3).equals(course2.timeDay.substring(4))) || (course1.timeDay.substring(4).equals(course2.timeDay.substring(0, 3))))) {
            System.out.println("Interference in class time by : " + course2.name);
            return true;
        }
        if (((course1.midFrom < course2.midUntil && course1.midFrom > course2.midFrom || course1.midUntil < course2.midUntil && course1.midUntil > course2.midFrom)) && (course1.midDate == course2.midDate && course1.midDate != 0)) {
            System.out.println("Interference in midTest by : " + course2.name);
            return true;
        }
        if ((course1.finalFrom < course2.finalUntil && course1.finalFrom > course2.finalFrom || course1.finalUntil < course2.finalUntil && course1.finalUntil > course2.finalFrom) || (course1.finalDate == course2.finalDate && course1.finalDate != 0)) {
            System.out.println("Interference in finalTest by : " + course2.name);
            return true;
        }
        return false;
    }

    private void AddStudent(Integer user, Integer intCollege, Integer intCourse) {
        Student.username2student.get(user).unitTotalCapacity += University.colleges.get(intCollege).courses.get(intCourse).unit;
        if (University.colleges.get(intCollege).courses.get(intCourse) instanceof PublicLesson) {
            Student.username2student.get(user).unitPublicCapacity += University.colleges.get(intCollege).courses.get(intCourse).unit;
        }
        University.colleges.get(intCollege).courses.get(intCourse).fullCapacity++;
        University.colleges.get(intCollege).courses.get(intCourse).students.add(Student.username2student.get(user));
        Student.username2student.get(user).studentCourses.add(University.colleges.get(intCollege).courses.get(intCourse));
        System.out.println("Adding done successfully now What do you want now : ");
        System.out.println("b - Go back       ");
        System.out.println("en- Go Enter page ");
        System.out.println("ex- Exit          ");
        System.out.println();
        input = scanner.next();
        exitORenter(input);
        switch (input) {
            case ("b"):
                SelectUnit(user, intCollege);
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                System.out.println("unExpected choice for " + input);
                System.out.println("So let's go SelectUnit page : ");
                System.out.println();
                SelectUnit(user, intCollege);
        }
    }

    private void DeleteCourse(Integer user) {
        System.out.println("    Which one do you want to delete (Enter their code)?");
        System.out.println("Code#Course name         #       Teacher name         #   FullyCap/Cap   #      Time       #         MidTest       #        FinalTest       #   Unit   #  S or P   ");
        Course.totalCourses.clear();
        for (int i = 0; i < Student.username2student.get(user).studentCourses.size(); i++) {
            System.out.println(Student.username2student.get(user).studentCourses.get(i));
            Course.totalCourses.put(Student.username2student.get(user).studentCourses.get(i).code, i);
        }
        if (Student.username2student.get(user).studentCourses.isEmpty()) {
            System.out.println("Your list is Empty");
        }
        System.out.println();
        System.out.println("b -  Go back to Register page   ");
        System.out.println("en- Go Enter page               ");
        System.out.println("ex- Exit                        ");
        System.out.println();
        String input1 = scanner.next();
        exitORenter(input1);
        in:
        switch (input1) {
            case ("b"):
                Register(user);
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                int input2 = 0;
                for (int j = 0; j < input1.length(); j++) {
                    if (!(input1.charAt(j) > 47 && input1.charAt(j) < 58)) {
                        System.out.println("UnExpected answer  ");
                        System.out.println("Please try again : ");
                        System.out.println();
                        DeleteCourse(user);
                        break in;
                    } else {
                        input2 += input1.charAt(j) - 48;
                        input2 *= 10;
                    }
                }
                input2 /= 10;
                if (Course.totalCourses.get(input2) < Student.username2student.get(user).studentCourses.size()) {
                    Course a = Student.username2student.get(user).studentCourses.get(Course.totalCourses.get(input2));
                    Student.username2student.get(user).unitTotalCapacity -= a.unit;
                    if (a instanceof PublicLesson) {
                        Student.username2student.get(user).unitPublicCapacity -= a.unit;
                    }
                    a.fullCapacity--;
                    a.students.remove(Student.username2student.get(user));
                    Student.username2student.get(user).studentCourses.remove(a);
                    System.out.println("Deleting done successfully now What do you want now : ");
                    System.out.println("b-  Go Deleting page");
                    System.out.println("en- Go Enter page   ");
                    System.out.println("ex- Exit            ");
                    System.out.println();
                    input = scanner.next();
                    exitORenter(input);
                    switch (input) {
                        case ("b"):
                            DeleteCourse(user);
                        case ("en"):
                            Enter();
                            return;
                        case ("ex"):
                            System.exit(0);
                        default:
                            System.out.println("unExpected choice for     " + input);
                            System.out.println("So let's go Deleting page again : ");
                            System.out.println();
                            DeleteCourse(user);
                    }
                } else {
                    System.out.println("No course has this code");
                    System.out.println();
                    DeleteCourse(user);
                }
        }
    }
    //First session done

}
