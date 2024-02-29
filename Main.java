public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!!!");
        SpecialLesson course=new SpecialLesson(101,200,101,4,"Math1","Dr.Pournaki","10.59-12.30 Sat ---","09.00-12.00_05.31","09.00-12.00/12.22");
        System.out.println(CLI.Specification(course));
        System.out.println(course.timeFrom);
        System.out.println(course.timeUntil);
        System.out.println(course.timeDay);
        System.out.println(course.midFrom);
        System.out.println(course.midUntil);
        System.out.println(course.midDate);
        System.out.println(course.finalFrom);
        System.out.println(course.finalUntil);
        System.out.println(course.finalDate);
    }
}