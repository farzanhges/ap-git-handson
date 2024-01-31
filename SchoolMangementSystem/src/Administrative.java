import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class Administrative extends User {
    public static Integer numTeachers  = 0;
    private static Integer numberOfAdmins = 1;
    boolean login;
    private  ArrayList < Administrative > admins;
    private  ArrayList < Student > students;
    private  ArrayList < Teacher > teachers;
    private  ArrayList < CRoom > classes;

    public Administrative() {
        this.userName = "admin";
        this.password = "admin";
    }
    public void initialize(ArrayList<Student> students, ArrayList<Teacher> teachers, ArrayList<Administrative> admins, ArrayList<CRoom> classes){
        this.students = students;
        this.teachers = teachers;
        this.classes = classes;
        this.admins = admins;
        login = true;
        while(login == true) {
            System.out.printf("What do you want to do?%n 1.Add Student%n 2.Remove Student%n 3.Add teacher%n 4.Remove Teacher" +
                    "%n 5.Add ClassRoom%n 6.Remove ClassRoom%n 7.add Administrative %n 8. remove Administrative %n 9.List Students%n 10.List Teacher%n 11.list Classrooms%n 12.list Administratives%n 13.logout" +
                    "%n");
            Scanner input = new Scanner(System.in);
            Integer flag = input.nextInt();
            input.nextLine();
            switch(flag) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    System.out.println("Please enter student's name that you want to remove");
                    String dummy1 = input.nextLine();
                    removeStudent(dummy1);
                    break;
                case 3:
                    numTeachers++;
                        addTeacher();
                    break;
                case 4:
                    System.out.println("Please enter teacher's name that you want to remove");
                    String dummy2 = input.nextLine();
                    removeTeacher(dummy2);
                    break;
                case 5:
                    addClass();
                    break;
                case 6:
                    System.out.println("Please enter name of the class you want to remove");
                    String dummy4 = input.nextLine();
                    removeClass(dummy4);
                    break;
                case 7:
                    numberOfAdmins++;
                    addAdministrative();
                    break;
                case 8:
                    System.out.println("Please enter administrative's name that you want to remove:");
                    String dummy3 = input.nextLine();
                    removeAdministrative(dummy3);
                    break;
                case 9:
                    getStudents();
                    break;
                case 10:
                    getTeachers();
                    break;
                case 11:
                    getClasses();
                    break;
                case 12:
                    getAdministratives();
                default:
                    login = false;
                }
            }
        }

    public void addStudent(){
        Student student = new Student();
        student.setName();
        student.setPhoneNum();
        student.setYearOfArrival();
        student.setEmailAddress();
        student.setGrade();
        student.setMyClass();
        Integer ActualnumStudent = students.size();
        ActualnumStudent++;
        student.setUserName();
        student.setPassword(student.getPhoneNum());
        this.students.add(student);
        String pathOfStudent = "D:\\University\\Advanced programming\\SchoolMangementSystem\\Students";
        for(int i = 0; i < this.students.size(); i++) {
            String fileName = this.students.get(i).getUserName();
            try {
                File f = new File(pathOfStudent + '\\' + fileName);
                FileOutputStream fOutput = new FileOutputStream(f + ".txt");
                ObjectOutputStream output = new ObjectOutputStream(fOutput);
                output.writeObject(this.students.get(i));
                output.close();
                fOutput.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void removeStudent(String name) {
        for(int i=0; i<this.students.size(); i++){
            if(this.students.get(i).getName().equals(name)){
                Student a1 = this.students.get(i);
                String userName = a1.getUserName();
                String path = "D:\\University\\Advanced programming\\SchoolMangementSystem\\Students";
                String fileName = userName+".txt";
                System.out.println(fileName);
                File f = new File((path + "\\" + fileName));
                f.delete();
                this.students.remove(a1);
            }
        }

    }
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName();
        teacher.setPhoneNum();
        teacher.setYearOfArrival();
        teacher.setEmailAddress();
        teacher.setUserName();
        Integer ActualnumTeachers = teachers.size();
        ActualnumTeachers++;
        teacher.setPassword(teacher.getPhoneNum());
        this.teachers.add(teacher);
        String pathOfTeachers = "D:\\University\\Advanced programming\\SchoolMangementSystem\\Teachers";
        for (int i = 0; i < this.teachers.size(); i++) {
            String fileName = this.teachers.get(i).getUserName();
            try {
                File f = new File(pathOfTeachers + '\\' + fileName);
                FileOutputStream fOutput = new FileOutputStream(f + ".txt");
                ObjectOutputStream output = new ObjectOutputStream(fOutput);
                output.writeObject(this.teachers.get(i));
                output.close();
                fOutput.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void removeTeacher(String name) {
        for(int i=0; i<this.teachers.size(); i++){
            if(teachers.get(i).getName().equals(name)){
                Teacher a1 = this.teachers.get(i);
                String userName = a1.getUserName();
                String path = "D:\\University\\Advanced programming\\SchoolMangementSystem\\Teachers";
                String fileName = userName+".txt";
                System.out.println(fileName);
                File f = new File((path + "\\" + fileName));
                f.delete();
                teachers.remove(a1);
            }
        }
    }
    @Override
    public void setUserName(){
        this.userName = "ad"+yearOfArrival.toString()+this.emailAddress;
    }
    public void addAdministrative(){
        Administrative admin = new Administrative();
        admin.setName();
        admin.setPhoneNum();
        admin.setYearOfArrival();
        admin.setEmailAddress();
        Integer ActualNumAdmins = admins.size();
        ActualNumAdmins++;
        admin.setUserName();
        admin.setPassword(admin.getPhoneNum());
        this.admins.add(admin);
        String pathOfAdmins = "D:\\University\\Advanced programming\\SchoolMangementSystem\\Admins";
        for (int i = 0; i < admins.size(); i++) {
            String fileName = this.admins.get(i).getUserName();
            try {
                File f = new File(pathOfAdmins + '\\' + fileName);
                FileOutputStream fOutput = new FileOutputStream(f + ".txt");
                ObjectOutputStream output = new ObjectOutputStream(fOutput);
                output.writeObject(this.admins.get(i));
                output.close();
                fOutput.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void removeAdministrative(String name) {
        for(int i=0; i<this.admins.size(); i++){
            if(admins.get(i).getName().equals(name)){
                Administrative a1 = this.admins.get(i);
                String userName = a1.getUserName();
                String path = "D:\\University\\Advanced programming\\SchoolMangementSystem\\Admins";
                String fileName = userName+".txt";
                System.out.println(fileName);
                File f = new File((path + "\\" + fileName));
                f.delete();
                teachers.remove(a1);
            }
        }
    }
    public void addClass() {
        CRoom classRoom = new CRoom();
        classRoom.setName();
        classRoom.setSchedule();
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getClassName().equals(classRoom.getName())){
                classRoom.addStudent(students.get(i));
            }
        }
        classes.add(classRoom);
        String pathOfClasses = "D:\\University\\Advanced programming\\SchoolMangementSystem\\ClassRooms";
        for (int i = 0; i < classes.size(); i++) {
            String fileName = this.classes.get(i).getName();
            try {
                File f = new File(pathOfClasses + '\\' + fileName);
                FileOutputStream fOutput = new FileOutputStream(f + ".txt");
                ObjectOutputStream output = new ObjectOutputStream(fOutput);
                output.writeObject(this.classes.get(i));
                output.close();
                fOutput.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeClass(String name) {
        for(int i=0; i<this.classes.size(); i++){
            if(classes.get(i).getName().equals(name)){
                CRoom a1 = this.classes.get(i);
                String name1 = a1.getName();
                String path = "D:\\University\\Advanced programming\\SchoolMangementSystem\\ClassRooms";
                String fileName = name1+".txt";
                System.out.println(fileName);
                File f = new File((path + "\\" + fileName));
                f.delete();
                classes.remove(a1);
            }
        }
    }

    public void getStudents() {
        for(Integer i=1; i <= students.size() ; i++){
            System.out.println(i.toString() + ". "+ students.get(i-1).getFirstName()+students.get(i-1).getLastName());
        }
    }

    public void getTeachers() {
        for(Integer i=1; i <= teachers.size() ; i++){
            System.out.println(i.toString() + ". "+ teachers.get(i-1).getFirstName()+teachers.get(i-1).getLastName());
        }
    }
    public void getAdministratives() {
        for(Integer i=1; i <= admins.size() ; i++){
            System.out.println(i.toString() + ". "+ admins.get(i-1).getFirstName()+admins.get(i-1).getLastName());
        }
    }

    public ArrayList < CRoom > getClasses() {
        for(Integer i = 1; i<= classes.size(); i++){
            System.out.println(i.toString() + ". " + classes.get(i-1).getName());
        }
        return classes;
    }
}
