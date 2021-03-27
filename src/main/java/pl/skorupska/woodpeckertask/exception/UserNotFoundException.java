package pl.skorupska.woodpeckertask.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String name) {
        super("User " + name + " not found");
    }
}
