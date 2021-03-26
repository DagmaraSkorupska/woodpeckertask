package pl.skorupska.woodpeckertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class Controller {

    private final UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/userCount")
    public int userCount(){
        return userService.countAllUser();
    }

    @GetMapping(value = "user/{age}")
    public long numberOfPersons(@PathVariable int age){
        return userService.numberOfPersonsAboveAge(age);
    }

    @GetMapping(value = "userAverage")
    public double averageAge() throws Exception {
        return userService.averageAge();
    }

    @GetMapping(value = "userHobbyAll")
    public Set<String> listHobbyAlly()  {
        return userService.listHobbyAll();
    }

    @GetMapping(value = "user/{name}")
    public boolean nameOfBase(@PathVariable String name)  {
        return userService.name(name);
    }



}
