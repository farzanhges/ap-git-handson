import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class CRoom implements Serializable {
    private String name;
    private String[][] schedule = new String[5][4];
    private ArrayList<Student> students = new ArrayList <Student> ();
    public void setSchedule(){
        System.out.println("set session:");
        Scanner input = new Scanner(System.in);
        for(Integer i=0;i<5;i++) {
            for(Integer j=0;j<4;j++){
                    System.out.println("You're setting day " + i.toString() + " And Your setting session " + j.toString());
                    System.out.println("Enter name of the teacher that's gonna teach this class at this time");
                    this.schedule[i][j] = input.nextLine();
            }
        }
    }
    public void addStudent(Student s){
        this.students.add(s);
    }
    public void setName(){
        System.out.println("Enter the name you want to set for classroom");
        Scanner input = new Scanner(System.in);
        this.name = input.nextLine();
    }
    public ArrayList <Student> getStudents(){
        return this.students;
    }
    public String[][] getSchedule(){
        return this.schedule;
    }
    public String getName(){
        return this.name;
    }
}
