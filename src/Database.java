public class Database {
    private String [] userNames = new String[10];
    private String [] passwords = new String[10];
    private int userNamesCapacity = 10;

    public Database(){}

    public Boolean createAccount(String username, String password){
        // insert lower case
        if(this.userNamesFull()){
            return false;
        }
        int latestIndex = this.insertUserName(username);
        this.insertPassword(latestIndex, password);
        return true;
    }

    public Boolean login(String userName, String password){
        return this.checkUsername(userName) && this.checkPassword(userName, password);
    }


    private int insertUserName(String userNameAttempt){
        int latestIndex = 0;
        Boolean foundIndex = false;
        for(int i =0; i < userNames.length; i++){
            if(!(userNames[i] == null) && !foundIndex && userNames[i].length() == 0){
                latestIndex = i;
                foundIndex = true;
            }
        }
        this.userNames[latestIndex] = userNameAttempt.toLowerCase();
        return latestIndex;
    }

    private void insertPassword(int latestIndex, String passwordAttempt){
        this.passwords[latestIndex] = passwordAttempt;
    }

    private Boolean userNamesFull(){
        int currentUserNames = 0;
        for(int i =0; i < userNames.length; i++){
            if(!(userNames[i] == null)){
                currentUserNames++;
            }
        }
        return currentUserNames == userNamesCapacity;
    }

    private Boolean checkUsername(String userNameAttempt){
        for(int i =0; i < userNames.length; i++){
            if(!(userNames[i] == null) && userNameAttempt.toLowerCase().equals(userNames[i])) {
                return true;
            }
        }
        return false;
    }

    private int getPasswordIndex(String username){
        for(int i =0; i < userNames.length; i++){
            if( !(userNames[i] == null) && this.userNames[i] == username){
                return i;
            }
        }
        return 0;
    }

    private Boolean checkPassword(String userName, String Password){
        int PasswordIndex = this.getPasswordIndex(userName);
        return Password.equals(this.passwords[PasswordIndex]);
    }
}
