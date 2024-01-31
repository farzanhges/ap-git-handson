import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends User {
    private String subject;
    private ArrayList<CRoom> myClass = new ArrayList<>();
    public void initialize(){
        boolean login = true;
        while(login == true) {
            System.out.println("What do you want to do?");
            System.out.println("1. Check schedule\n2. Add grade for students\n3.Logout");
            Scanner input = new Scanner(System.in);
            Integer flag = input.nextInt();
            switch (flag) {
                case 1:
                    printSchedule();
                    break;
                case 2:
                    System.out.println("which class would you want to add grades for?");
                    for(Integer i = 0; i < myClass.size(); i++){
                        System.out.println(i.toString()+"."+ myClass.get(i).getName());
                    }
                    Integer flag2 = input.nextInt();
                    if(0 <= flag2 && flag2 < myClass.size()){
                        ArrayList <Student> classStudents = myClass.get(flag2).getStudents();
                        for(Integer i = 0; i < classStudents.size(); i++){
                            System.out.println("entering grade for " + classStudents.get(i).getName());
                            classStudents.get(i).addGrade();
                        }
                    }
                case 3:
                    login = false;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setUserName() {
        this.userName = "t" + this.yearOfArrival.toString() + this.emailAddress;
    }

    public void printSchedule() {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n"," ","First Period","Second Period","Third Period","Forth Period");
        boolean helper = false;
        for (Integer k = 0; k < 5; k++) {
            String[] Days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
            System.out.printf("%-20s", Days[k]+":");
            for (Integer j = 0; j < 4; j++) {
                for (Integer i = 0; i < myClass.size(); i++) {
                    String[][] schedule = myClass.get(i).getSchedule();
                    if (schedule[k][j].equals(this.getName())) {
                        System.out.printf("%-20s", myClass.get(i).getName());
                        helper = true;
                    }
                }
                if(helper != true){
                    System.out.printf("%-20s","clear");
                    helper = false;
                }
            }
            System.out.println();
        }
    }

    public void setMyclasses(ArrayList<CRoom> classes) {
        for(int i = 0; i < classes.size(); i++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 4; k++){
                    if(classes.get(i).getSchedule()[j][k].equals(this.getName())){
                        myClass.add(classes.get(i));
                    }
                    for(int t = 0; t < myClass.size()-1; t++){
                        if(classes.get(i).equals(myClass.get(t))){
                            myClass.removeLast();
                        }
                    }
                }
            }
        }
    }
}

