package pl.skorupska.woodpeckertask;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("User not found");
    }
}
