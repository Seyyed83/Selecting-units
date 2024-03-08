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
                AdminUsername();
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

    private void AdminUsername() {
        input = scanner.next();
        if (Admin.admin.userName.equals(input)) {
            System.out.println("Please tell me AdminPassword : ");
            System.out.println();
            AdminPassword();
        } else {
            System.out.println("Isn't True                 ");
            System.out.println("Please choose one of these ");
            System.out.println("1- try again :             ");
            System.out.println("en- go Enter page          ");
            System.out.println("ex- Exit                   ");
            System.out.println();
            input = scanner.next();
            exitORenter(input);
            switch (input) {
                case ("1"):
                    System.out.println("Please tell me Admin username : ");
                    System.out.println();
                    AdminUsername();
                case ("en"):
                    Enter();
                    return;
                case ("ex"):
                    System.exit(0);
                default:
                    System.out.println("unExpected choice      " + input);
                    System.out.println("Please try again for username : ");
                    System.out.println();
                    AdminUsername();
            }
        }
    }

    private void AdminPassword() {
        input = scanner.next();
        if (Admin.admin.password.equals(input)) {
            System.out.print("You enter successfully ");
            System.out.println();
            RegisterAdmin();
        } else {
            System.out.println("    Wrong password !!!          ");
            System.out.println("    Please choose one of these  ");
            System.out.println("1-  Try again for password :    ");
            System.out.println("en- Go Enter page               ");
            System.out.println("ex- Exit                        ");
            System.out.println();
            input = scanner.next();
            exitORenter(input);
            switch (input) {
                case ("1"):
                    System.out.println("Please tell me AdminPassword : ");
                    System.out.println();
                    AdminPassword();
                case ("en"):
                    Enter();
                    return;
                case ("ex"):
                    System.exit(0);
                default:
                    System.out.println("unExpected choice for " + input);
                    System.out.println("Please try again for password : ");
                    System.out.println();
                    AdminPassword();
            }
        }
    }

    private void RegisterAdmin() {
        System.out.println("Choose a College for see there Info and change , Or press c to create new one : ");
        for (int i = 0; i < University.colleges.size(); i++) {
            System.out.println(i + "-  " + University.colleges.get(i));
        }
        if (University.colleges.isEmpty()) {
            System.out.println("College list is Empty");
        }
        System.out.println("en- Enter page (Go back)                  ");
        System.out.println("ex- Exit                                  ");
        System.out.println("c - Create a new College                  ");
        System.out.println("{-d+*+(College Number)} - Deleting College");
        System.out.println();
        input = scanner.next();
        exitORenter(input);
        switch (input) {
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            case ("c"):
                AddCollege();
                RegisterAdmin();
                return;
            default:
                boolean isDelete = false;
                if (input.startsWith("-d*")) {
                    isDelete = true;
                    input = input.substring(3);
                }
                int a = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) > 47 && input.charAt(i) < 58) {
                        a += input.charAt(i) - 48;
                        a *= 10;
                    } else {
                        System.out.println("unExpected input   ");
                        System.out.println("Please try again : ");
                        System.out.println();
                        RegisterAdmin();
                    }
                }
                a /= 10;
                if (University.colleges.size() > a) {
                    if (isDelete) {
                        if (!University.colleges.get(a).courses.isEmpty()) {
                            System.out.println("It shouldn't have any course ");
                            System.out.println("Please try again :           ");
                            System.out.println();
                        } else {
                            University.colleges.remove(University.colleges.get(a));
                            System.out.println("Removed successfully");
                        }
                        RegisterAdmin();
                    } else {
                        CoursesPage(a);
                    }
                } else {
                    System.out.println("Your Choose is bigger than numbers of colleges");
                    System.out.println("Please try again : ");
                    System.out.println();
                    RegisterAdmin();
                }
        }
    }

    private void AddCollege() {
        System.out.println();
        System.out.println("Please enter College name : ");
        System.out.println();
        String inputCollege = scanner.next();
        College newCollege = new College(inputCollege);
    }

    private void CoursesPage(Integer intCollege) {
        System.out.println("Choose courses by their code (You can see their students)");
        Course.totalCourses.clear();
        System.out.println("Code#Course name         #       Teacher name         #   FullyCap/Cap   #      Time       #         MidTest       #        FinalTest       #   Unit   #  S or P   ");
        for (int k = 0; k < University.colleges.get(intCollege).courses.size(); k++) {
            System.out.println(Specification(University.colleges.get(intCollege).courses.get(k)));
            Course.totalCourses.put(University.colleges.get(intCollege).courses.get(k).code, k);
        }
        if (University.colleges.get(intCollege).courses.isEmpty()) {
            System.out.println("This College is Empty");
        }
        System.out.println();
        System.out.println("{ - + d + * + (Course Number)} -   Deleting Course ");
        System.out.println("{ - + cap + * + (Course Number)} - Change Capacity ");
        System.out.println("a  -  Add Course                             ");
        System.out.println("b  -  Go back to RegisterAdmin page          ");
        System.out.println("en -  Go Enter page                          ");
        System.out.println("ex -  Exit                                   ");
        System.out.println();
        input = scanner.next();
        exitORenter(input);
        switch (input) {
            case ("a"):
                AddCourse(intCollege);
            case ("b"):
                RegisterAdmin();
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                boolean isDelete = false, isCap = false;
                if (input.startsWith("-d*")) {
                    isDelete = true;
                    input = input.substring(3);
                } else if (input.startsWith("-cap*")) {
                    isCap = true;
                    input = input.substring(5);
                }
                int a = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) > 47 && input.charAt(i) < 58) {
                        a += input.charAt(i) - 48;
                        a *= 10;
                    } else {
                        System.out.println("unExpected input   ");
                        System.out.println("Please try again : ");
                        System.out.println();
                        CoursesPage(intCollege);
                        return;
                    }
                }
                a /= 10;
                if (Course.totalCourses.containsKey(a)) {
                    a = Course.totalCourses.get(a);
                    if (isDelete) {
                        System.out.println(a);
                        University.colleges.get(intCollege).courses.remove(a);
                        System.out.println("The Course is deleted    ");
                        System.out.println("Let's go to Register Page");
                        RegisterAdmin();
                    } else if (isCap) {
                        ChangeCapacity(intCollege, a);
                    } else {
                        CourseInfo(intCollege, a);
                    }
                } else {
                    System.out.println("No course has this code");
                    System.out.println("Please try again :     ");
                    System.out.println();
                    CoursesPage(intCollege);
                }
        }
    }
    private void AddCourse(Integer intCollege) {
        System.out.println("Enter variable that requested");
        System.out.println("CourseName : ");
        String name = scanner.next();
        System.out.println("TeacherName : ");
        String teacher = scanner.next();
        System.out.println("Time (example 11.59-13.30#Sat#Thu) : ");
        String time = scanner.next();
        System.out.println("MidTest (example 09.00-12.00_05.31 or also ---(if you don't want to have midTest)) : ");
        String mid = scanner.next();
        System.out.println("FinalTest (example 09.00-12.00_04.31 or also ---(if you don't want to have finalTest)) : ");
        String Final = scanner.next();
        GetInts(name, teacher, time, mid, Final, intCollege);
    }

    private void GetInts(String name, String teacherName, String time, String mid, String Final, Integer intCollege) {
        System.out.println("Code : ");
        String codeS = scanner.next();
        System.out.println("Capacity : ");
        String capacityS = scanner.next();
        System.out.println("Unit : ");
        String unitS = scanner.next();
        int code = 0, capacity = 0, unit = 0;
        for (int i = 0; i < codeS.length(); i++) {
            if (codeS.charAt(i) > 47 && codeS.charAt(i) < 58) {
                code += codeS.charAt(i) - 48;
                code *= 10;
            } else {
                System.out.println("unExpected");
                System.out.println();
                GetInts(name, teacherName, time, mid, Final, intCollege);
            }
        }
        code /= 10;
        for (int i = 0; i < capacityS.length(); i++) {
            if (capacityS.charAt(i) > 47 && capacityS.charAt(i) < 58) {
                capacity += capacityS.charAt(i) - 48;
                capacity *= 10;
            } else {
                System.out.println("unExpected");
                System.out.println();
                GetInts(name, teacherName, time, mid, Final, intCollege);
            }
        }
        for (College col : University.colleges) {
            for (Course cou : col.courses) {
                if (code == cou.code) {
                    System.out.println("Repeated Code !!! ".concat("From College ").concat(col.name).concat(" Course ").concat(cou.name));
                    System.out.println();
                    GetInts(name, teacherName, time, mid, Final, intCollege);
                }
            }
        }
        capacity /= 10;
        for (int i = 0; i < unitS.length(); i++) {
            if (unitS.charAt(i) > 47 && unitS.charAt(i) < 58) {
                unit += unitS.charAt(i) - 48;
                unit *= 10;
            } else {
                System.out.println("unExpected");
                System.out.println();
                GetInts(name, teacherName, time, mid, Final, intCollege);
            }
        }
        unit /= 10;
        System.out.println("Is it Public course ? (0 - No / 1 - Yes)");
        System.out.println("b-  Go back to Course page ");
        System.out.println("en- Go Enter page          ");
        System.out.println("ex- Exit                   ");
        System.out.println();
        String isPublic = scanner.next();
        exitORenter(isPublic);
        switch (isPublic) {
            case ("0"):
                SpecialLesson NewS = new SpecialLesson(code, capacity, 0, unit, name, teacherName, time, mid, Final, University.colleges.get(intCollege));
                CoursesPage(intCollege);
                break;
            case ("1"):
                PublicLesson NewP = new PublicLesson(code, capacity, 0, unit, name, teacherName, time, mid, Final, University.colleges.get(intCollege));
                CoursesPage(intCollege);
                break;
            case ("b"):
                CoursesPage(intCollege);
                break;
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                System.out.println("Unexpected input   ");
                System.out.println("Please try again : ");
                GetInts(name, teacherName, time, mid, Final, intCollege);
        }
    }

    private void ChangeCapacity(Integer intCollege, Integer intCourse) {
        System.out.println("Fully/Total     " + University.colleges.get(intCollege).courses.get(intCourse).fullCapacity + "/" + University.colleges.get(intCollege).courses.get(intCourse).capacity);
        System.out.println("b-  Go back to Course page          ");
        System.out.println("en- Go Enter page                   ");
        System.out.println("ex- Exit                            ");
        System.out.println("    Or Enter yor desired Capacity : ");
        System.out.println();
        input = scanner.next();
        exitORenter(input);
        switch (input) {
            case ("b"):
                CoursesPage(intCollege);
                break;
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                int a = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) > 47 && input.charAt(i) < 58) {
                        a += input.charAt(i) - 48;
                        a *= 10;
                    } else {
                        System.out.println("unExpected input check it " + input);
                        System.out.println();
                        ChangeCapacity(intCollege, intCourse);
                    }
                }
                a /= 10;
                if (a <= University.colleges.get(intCollege).courses.get(intCourse).fullCapacity) {
                    int b=University.colleges.get(intCollege).courses.get(intCourse).capacity;
                    University.colleges.get(intCollege).courses.get(intCourse).fullCapacity=a;
                    University.colleges.get(intCollege).courses.get(intCourse).capacity = a;
                    for (int j=a;j<b;j++){
                        University.colleges.get(intCollege).courses.get(intCourse).students.remove(j);
                    }
                    CoursesPage(intCourse);
                } else {
                    University.colleges.get(intCollege).courses.get(intCourse).capacity=a;
                    CoursesPage(intCollege);
                }

        }
    }

    private void CourseInfo(Integer intCollege, Integer intCourse) {
        System.out.println("     Choose Student to Remove from this course : ");
        for (Student student:University.colleges.get(intCollege).courses.get(intCourse).students){
            System.out.println(student.userName+" : "+student.name.concat(" -   (Password) -> ")+student.password);
        }
        if (University.colleges.get(intCollege).courses.get(intCourse).students.isEmpty()) {
            System.out.println("     No student get this course");
        }
        System.out.println("     Send another Username to add in this course ");
        System.out.println("A  - Send A to see all students                  ");
        System.out.println("b  - Go back to Course page                      ");
        System.out.println("en - Go Enter page                               ");
        System.out.println("ex - Exit                                        ");
        System.out.println();
        input = scanner.next();
        exitORenter(input);
        switch (input) {
            case ("A"):
                ShowStudent(intCollege, intCourse);
            case ("b"):
                CoursesPage(intCollege);
                return;
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                int a = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) > 47 && input.charAt(i) < 58) {
                        a += input.charAt(i) - 48;
                        a *= 10;
                    } else {
                        System.out.println("unExpected input   ");
                        System.out.println("Please try again : ");
                        System.out.println();
                        CourseInfo(intCollege, intCourse);
                    }
                }
                a /= 10;
                boolean trueInput = false;
                if (University.totalStudents.containsKey(a)) {
                    Course ab = University.colleges.get(intCollege).courses.get(intCourse);
                    Student stu = University.totalStudents.get(a);
                    if (University.colleges.get(intCollege).courses.get(intCourse).students.contains(University.totalStudents.get(a))) {
                        stu.unitTotalCapacity -= ab.unit;
                        if (ab instanceof PublicLesson) {
                            stu.unitPublicCapacity -= ab.unit;
                        }
                        ab.fullCapacity--;
                        ab.students.remove(stu);
                        stu.studentCourses.remove(ab);
                        trueInput = true;
                        System.out.println("Student remove Successfully");
                        System.out.println();
                        CourseInfo(intCollege, intCourse);
                    } else {
                        stu.unitTotalCapacity += ab.unit;
                        if (ab instanceof PublicLesson) {
                            stu.unitPublicCapacity += ab.unit;
                        }
                        ab.fullCapacity++;
                        ab.students.add(stu);
                        stu.studentCourses.add(ab);
                        System.out.println("Student adding Successfully");
                        System.out.println();
                        CourseInfo(intCollege, intCourse);
                    }
                }
                if (!trueInput) {
                    System.out.println("unExpected input   ");
                    System.out.println("Please try again : ");
                    System.out.println();
                    CourseInfo(intCollege, intCourse);
                }
        }
    }

    private void ShowStudent(Integer intCollege, Integer intCourse) {
        for (Student student : University.totalStudents.values()) {
            System.out.println(student + " : " + student.userName + " -   (Password)->" + student.password);
        }
        System.out.println("     Now what do you want  ");
        System.out.println("b  - Go back to CourseInfo ");
        System.out.println("en - Go Enter page         ");
        System.out.println("ex - Exit                  ");
        System.out.println();
        input = scanner.next();
        exitORenter(input);
        switch (input) {
            case ("b"):
                CourseInfo(intCollege, intCourse);
                return;
            case ("en"):
                Enter();
                return;
            case ("ex"):
                System.exit(0);
            default:
                System.out.println("unExpected input ");
                System.out.println("Let's go back    ");
                System.out.println();
                CourseInfo(intCollege, intCourse);
        }
    }
}
