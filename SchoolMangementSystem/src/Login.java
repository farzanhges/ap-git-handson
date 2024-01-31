import java.io.*;
import java.util.ArrayList;

public class Login {
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Administrative> admins = new ArrayList<>();
    private ArrayList<CRoom> classes = new ArrayList<>();
    public void Login(String userName, String password){
        File studentPath = new File("D:\\University\\Advanced programming\\SchoolMangementSystem\\Students");
        File[] studentList = studentPath.listFiles();
        if(studentList != null){
            for(int i = 0; i<studentList.length; i++){
                try{
                    FileInputStream path = new FileInputStream(studentList[i]);
                    ObjectInputStream in = new ObjectInputStream(path);
                    students.add((Student) in.readObject());
                    in.close();
                    path.close();
                }catch(IOException | ClassNotFoundException e){
                    e.printStackTrace();
                }

            }
        }
        File teacherPath = new File("D:\\University\\Advanced programming\\SchoolMangementSystem\\Teachers");
        File[] teacherList = teacherPath.listFiles();
        if(teacherList != null){
            for(int i = 0; i < teacherList.length; i++){
                try{
                    FileInputStream path = new FileInputStream(teacherList[i]);
                    ObjectInputStream in = new ObjectInputStream(path);
                    teachers.add((Teacher) in.readObject());
                    in.close();
                    path.close();
                }catch(IOException | ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
        File adminPath = new File("D:\\University\\Advanced programming\\SchoolMangementSystem\\Admins");
        File[] adminList = adminPath.listFiles();
        if(adminList != null){
            for(int i = 0; i < adminList.length; i++){
                try{
                    FileInputStream path = new FileInputStream(adminList[i]);
                    ObjectInputStream in = new ObjectInputStream(path);
                    admins.add((Administrative) in.readObject());
                    in.close();
                    path.close();
                }catch(IOException | ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
        Student s = searchStudents(userName, password);
        Teacher t = searchTeachers(userName, password);
        Administrative ad = searchAdmins(userName, password);
        File classPath = new File("D:\\University\\Advanced programming\\SchoolMangementSystem\\ClassRooms");
        File[] classList = classPath.listFiles();
        if(classList != null){
            for(int i = 0; i < classList.length; i++){
                try{
                    FileInputStream path = new FileInputStream(classList[i]);
                    ObjectInputStream in = new ObjectInputStream(path);
                    classes.add((CRoom) in.readObject());
                    in.close();
                    path.close();
                }catch(IOException | ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
        if(s != null){
            s.initialize();
        }else if(t!=null){
            t.initialize();
        }else if(ad != null){
            ad.initialize(this.students, this.teachers, this.admins,this.classes);
        }else if(userName.equals("admin") && password.equals("admin")){
            Administrative a = new Administrative();
            a.initialize(this.students, this.teachers, this.admins, this.classes);
        }else {
            System.out.println("username & password aren't correct!");
        }
        String pathOfStudent = "D:\\University\\Advanced programming\\SchoolMangementSystem\\Students";
        for(int i = 0; i < students.size(); i++) {
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
    public Student searchStudents(String userName, String password){
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getUserName().equals(userName) && students.get(i).getPassword().equals(password)){
                return students.get(i);
            }
        }
        return null;
    }
    public Teacher searchTeachers(String userName, String password){
        for(int i = 0; i < teachers.size(); i++){
            if(teachers.get(i).getUserName().equals(userName) && teachers.get(i).getPassword().equals(password)){
                return teachers.get(i);
            }
        }
        return null;
    }
    public Administrative searchAdmins(String userName, String password){
        for(int i = 0; i < admins.size(); i++){
            if(admins.get(i).getUserName().equals(userName) && admins.get(i).getPassword().equals(password)){
                return admins.get(i);
            }
        }
        return null;
    }

}
