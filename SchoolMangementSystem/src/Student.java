import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{
    private ArrayList <Float> grades = new ArrayList <Float>(); // grades represent specific students scores in exams and all
    private ArrayList<String> subject = new ArrayList <String>();
    private String myClass;
    private String grade; // this grade reporesents the class our this student is in
    public void initialize(){
        boolean login = true;
        while(login == true){
            System.out.println("What do you want to do?\n1.List Grades\n2.logout\n");
            Scanner input = new Scanner(System.in);
            Integer flag = input.nextInt();
            switch(flag){
                case 1:
                    for(Integer i = 0; i < grades.size(); i++){
                        System.out.printf("%-10s%-20s%-20s%n", i.toString(), subject.get(i), grades.get(i).toString());
                    }
                case 2:
                    login = false;
                default:
                    System.out.printf("Invalid input");
            }
        }

    }
    public String getClassName() {
        return this.myClass;
    }

    public void addGrade(){
        System.out.println("What is the course that you're adding grade for?");
        Scanner input = new Scanner(System.in);
        this.subject.add(input.nextLine());
        System.out.println("what is the grade you want to add?");
        this.grades.add((float) input.nextFloat());
        System.out.println();
    }
    public void setMyClass(){
        System.out.println("What's the name of the class you want to put this student in");
        Scanner input = new Scanner(System.in);
        String myClass = input.nextLine();
        this.myClass = myClass;
    }
    @Override
    public void setUserName(){
        this.userName = yearOfArrival.toString() + grade.toString() + this.emailAddress;
    }
    public void setGrade(){
        System.out.println("What grade is the student in?");
        Scanner input = new Scanner(System.in);
        this.grade = input.nextLine();
    }
    public void seeGrades() {
        if(this.grades != null) {
            for (int i = 0; i < this.grades.size(); i++) {
                System.out.printf("%-20s%20.2f%n", this.subject.get(i), this.grades.get(i));
            }
        }else{
            System.out.println("No grades have been set for you!!!");
        }
    }
}
