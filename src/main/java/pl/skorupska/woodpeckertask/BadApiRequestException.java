package pl.skorupska.woodpeckertask;

public class BadApiRequestException extends Throwable {
    public BadApiRequestException() {
        super("User not found");
    }
}
