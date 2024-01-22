package emailapp;
import java.util.Scanner;
import java.util.Random;


public class Email {
    private String firstName;                               // instance variable
    private String lastName;
    private String password; 
    private final int defaultPasswordLength = 10;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String email;
    private final String companySuffix = ".company.com";
    

    // Constructor to receive the first name and last name
    public Email( String firstName, String lastName ) {
        this.firstName = firstName;                         // firstName refers to local variable, it's being passed thru the parameter 
        this.lastName = lastName;                           // "This" keyword refering at the class level variable = the "public class" name
        System.out.println("New Employee: " + firstName + " " + lastName);


        // Call a method for the department - return the department 
        this.department = setDepartment();

        // Call a method that returns random password
        this.password = getMathRandomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Email syntax
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;

    }


    // Ask for the department method (else - if method)
    private String setDepartment() {
        System.out.print("""
                DEPARTMENT CODES  
                    1 for Sales 
                    2 for Development
                    3 for Accounting
                    0 to Quit
                Enter Department Codes:   """);
        Scanner scanner = new Scanner(System.in);
        int departChoice = scanner.nextInt();

        if( departChoice == 1 ) {                               // else-if
            return "sales";
        } else if( departChoice == 2 ) {
            return "development";
        } else if( departChoice == 3 ) {
            return "accounting";
        } else {
            return null;
        }
    }
    
    // Ask for the department method (switch method)
    private String setDepartmentSwitch() {
        System.out.print("""
                DEPARTMENT CODES  
                    1 for Sales 
                    2 for Development
                    3 for Accounting
                    0 to Quit
                Enter Department Codes: """);
        Scanner scanner = new Scanner(System.in);
        String departChoice = scanner.nextLine();

        switch( departChoice ) {
            case "1":
                return "Sales";
            case "2":
                return "Development";
            case "3":
                return "Accounting";
            default:
                break;
        }
        return departChoice;
    }



    // Generate a random password 1 (Using Random class)
    private String getRandomPassword( int length ) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%^&*";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for( int i = 0; i < length; i++ ) {
            int index = random.nextInt(passwordSet.length());                       // Random class
            char randomChar = passwordSet.charAt(index);
            stringBuilder.append(randomChar);           
        }
        return stringBuilder.toString();
    }

    // Generate random password 2 ( Using Math.random() method ) 
    private String getMathRandomPassword( int length ) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%^&*";
        char[] password = new char[ length ];
        for( int i = 0; i < length; i++ ) {
            int rand = (int) (Math.random() * passwordSet.length());                      // Math.random(); This method apply for double/float
            password[i] = passwordSet.charAt(rand);
            // System.out.println(password[i]);
        }
        return new String(password);
    }


    // Set the mailbox capacity
    public void setMailboxCapacity( int capacity ) {
        this.mailboxCapacity = capacity;                    // This is encapsulation that I can set some properties and hiding the actual property 
    } 
    public int getMailBoxCapacity() {
        return mailboxCapacity;
    }

    // Set the alternate email 
    public void setAlternateEmail( String altEmail ) {
        this.alternateEmail = altEmail;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Set methods to change the password 
    public void setChangePassword( String password ) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public String Display() {
        return "-".repeat(52) + "\nDISPLAY NAME: " + firstName + " " + lastName +
               "\nCOMPANY EMAIL: " + email +
               "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}