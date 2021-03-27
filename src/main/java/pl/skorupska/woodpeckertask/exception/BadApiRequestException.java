package pl.skorupska.woodpeckertask.exception;

public class BadApiRequestException extends RuntimeException {

    public BadApiRequestException() {
        super("Joke not found");
    }
}
