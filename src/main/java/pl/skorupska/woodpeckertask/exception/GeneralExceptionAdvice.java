package pl.skorupska.woodpeckertask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;

@ControllerAdvice
public class GeneralExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(BadApiRequestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String badApiRequest(BadApiRequestException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound(UserNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String fileNotFound(FileNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(AverageException.class)
    public String average(AverageException ex){
        return ex.getMessage();
    }
}

