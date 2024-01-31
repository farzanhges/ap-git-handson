import javax.management.relation.Role;
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.SecurityException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Date;
public abstract class User implements Serializable{
    protected String firstName;
    protected String lastName;
    protected String userName;
    protected String password;
    protected String phoneNum;
    protected String emailAddress;
    protected Integer yearOfArrival;
    protected String Role;
    public void setName(){
        System.out.println("please enter the name:");
        Scanner input = new Scanner(System.in);
        String firstName = input.next();
        String lastName = input.nextLine();
        this.firstName = firstName;
        this.lastName = lastName;
}

    public void setPhoneNum(){
        System.out.printf("%nPlease enter the phone number: %n");
        Scanner input = new Scanner(System.in);
        String phoneNum = input.nextLine();
        this.phoneNum = phoneNum;
    }
    public void setEmailAddress()
    {   System.out.printf("%nPlease enter the email address: %n");
        Scanner input = new Scanner(System.in);
        String emailAddress = input.nextLine();
        this.emailAddress = emailAddress;
    }
    public void setYearOfArrival(){
        Integer yearOfArrival = Year.now().getValue();
        this.yearOfArrival = yearOfArrival;
    }
    public abstract void setUserName();
    public void setPassword(String password){
        this.password = password;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getName(){
        return this.firstName + this.lastName;
    }
    public String getPassword() {
        return this.password;
    }
    public String getPhoneNum(){
        return this.phoneNum;
    }
}
