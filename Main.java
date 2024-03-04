import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Student ali=new Student(123,1234,"ali");
        System.out.println("Welcome!!!");
        System.out.println();
        College math=new College("Math");
        SpecialLesson course=new SpecialLesson(101,200,101,4,"PublicMath1","Dr.Pournaki","10.59-12.30 Sat ---","09.00-12.00_05.31","09.00-12.00/12.22",math);
//        ali.studentCourses.add(course);
//        System.out.println(course);
//        System.out.println(course.timeFrom);
//        System.out.println(course.timeUntil);
//        System.out.println(course.timeDay);
//        System.out.println(course.midFrom);
//        System.out.println(course.midUntil);
//        System.out.println(course.midDate);
//        System.out.println(course.finalFrom);
//        System.out.println(course.finalUntil);
//        System.out.println(course.finalDate);
//        Integer a=scanner.nextInt();
//        System.out.println(a);
        CLI cli=new CLI();
        cli.Enter();
    }
}