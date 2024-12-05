
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
                        while (userName.length() == 0){
                            System.out.print("Please create a username longer than 0 characters ([a-z][A-Z]): ");
                            userName = reader.nextLine();
                        }
                        System.out.print("Please create a password: ");
                        String password = reader.nextLine();
                        while (password.length() == 0){
                            System.out.print("Please create a password longer than 0 characters: ");
                            password = reader.nextLine();
                        }
                        System.out.print("Please reenter your password: ");
                        String password2 = reader.nextLine();

                        if(!(password.equals(password2))){
                            System.out.println("The passwords did not match");
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
                        while (userNameLogin.length() == 0){
                            System.out.print("Please enter a username longer than 0 characters ([a-z][A-Z]): ");
                            userNameLogin = reader.nextLine();
                        }
                        System.out.print("Please enter a password: ");
                        String passwordLogin = reader.nextLine();
                        while (passwordLogin.length() == 0){
                            System.out.print("Please enter a password longer than 0 characters: ");
                            passwordLogin = reader.nextLine();
                        }
                        if(loginDB.login(userNameLogin, passwordLogin)){
                            System.out.println("Trevor logged in!");
                            loggedIn = true;
                        }
                        else{
                            System.out.println("You failed to login!");
                        }
                        break;
                    case ("3"):
                        loginScriptStart = false;
                }
            }
        }
    }
}
