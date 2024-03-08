import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Student Ali=new Student(1,1234,"Ali");
        Student Hossein=new Student(2,1234,"Hossein");
        Student Mohamad=new Student(3,1234,"Mohamad");
        Student Yassin=new Student(4,1234,"Yasin");
        Student Sadra=new Student(5,1234,"Sadra");
        Student Sara=new Student(6,1234,"Sara");
        Student Reyhaneh=new Student(7,1234,"Reyhaneh");
        System.out.println("Welcome!!!");
        System.out.println();
        College math=new College("Math");
        College physic=new College("Physic");
        College computer=new College("Computer");
        SpecialLesson math1=new SpecialLesson(100,2,0,4,"PublicMath1","Dr.Pournaki","10.59-12.30#Sat#---","09.00-12.00_05.31","09.00-12.00/12.22",math);
        SpecialLesson math2=new SpecialLesson(101,10,0,4,"PublicMath2","Dr.Moqadasi","11.59-13.30#Thu#Sat","---","---",math);
        PublicLesson publicMath=new PublicLesson(200,10,0,2,"PublicCourse1","Me","07.30-09.30#Sun#Mon","---","09.00-12.00/12.12",math);
        SpecialLesson physic1=new SpecialLesson(102,10,0,3,"PublicPhysic1","DR.Baghram","11.59-13.30#Thu#Sat","---","09.00-12.00/12.12",physic);
        SpecialLesson physic2=new SpecialLesson(103,10,0,3,"PublicPhysic2","DR.Abolhasani","13.59-15.30#Thu#Sat","09.00-12.00/12.12","09.00-12.00/11.12",physic);
        PublicLesson publicPhysic=new PublicLesson(201,10,0,3,"PublicCourse2","Mamad","07.30-09.30#Tue#Wen","---","---",physic);
        SpecialLesson bp=new SpecialLesson(104,10,5,3,"BP","Dr.Fazli","15.59-17.30#Sat#---","---","---",computer);
        SpecialLesson ap=new SpecialLesson(105,10,0,3,"AP","Dr.Fazli","15.59-17.30#Sun#Wen","---","---",computer);
        PublicLesson publicComputer=new PublicLesson(202,10,0,2,"PublicCourse3","NemiDounam","10.30-12.30#Tue#Wen","---","---",computer);
        CLI cli=new CLI();
        cli.Enter();
    }
}