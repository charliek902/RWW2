
import java.util.Scanner;


public class main {

    public static void main(String[] args) {

        Database loginDB = new Database();
        Scanner reader = new Scanner(System.in);
        Boolean loginScriptStart = true;
        Boolean loggedIn = false;

        while(loginScriptStart){
            if(loggedIn){
                System.out.println("""
             Would Trevor like to 
             1) Log out - Press 1
             2) End Program - Press 2
            """);
                String key = reader.nextLine();
                switch(key){
                    case("1"):
                        loggedIn = false;
                        break;
                    case("2"):
                        loginScriptStart = false;
                }
            }
            else{
                System.out.println("""
             Would Trevor like to 
             1) Create a username and password- Press 1
             2) Login - Press 2
             3) End Program - Press 3
            """);
                String key = reader.nextLine();
                switch(key){
                    case("1"):
                        System.out.print("Please create a username ([a-z][A-Z]): ");
                        String userName = reader.nextLine();
                        System.out.print("Please create a password: ");
                        String password = reader.nextLine();
                        System.out.print("Please reenter your password: ");
                        String password2 = reader.nextLine();

                        if(!(password.equals(password2))){
                            System.out.println("THe passwords did not match");
                        }
                        else {
                            if (loginDB.createAccount(userName, password)) {
                                System.out.println("You have succesfully stored your details!");
                            } else {
                                System.out.println("You have exceeded the amount of usernames to create");
                            }
                        }
                        break;
                    case("2"):
                        System.out.print("Please enter a username ([a-z][A-Z]): ");
                        String userNameLogin = reader.nextLine();
                        System.out.print("Please enter a password: ");
                        String passwordLogin = reader.nextLine();
                        if(loginDB.login(userNameLogin, passwordLogin)){
                            System.out.println("Trevor logged in!");
                            loggedIn = true;
                        }
                        break;
                    case ("3"):
                        loginScriptStart = false;
                }
            }
        }
    }
}
