package pl.skorupska.woodpeckertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.skorupska.woodpeckertask.exception.BadApiRequestException;

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
    public int userCount() {
        return userService.countAllUser();
    }

    @GetMapping(value = "userAge/{age}")
    public long numberOfUser(@PathVariable int age) {
        return userService.numberOfUserAboveAge(age);
    }

    @GetMapping(value = "userAverage")
    public double averageAge() throws Exception {
        return userService.averageAge();
    }

    @GetMapping(value = "userAllHobby")
    public Set<String> listAllHobby() {
        return userService.listHobbyAll();
    }

    @GetMapping(value = "userAllName")
    public List<String> allNameOfBases() {
        return userService.allNameOfBases();
    }

    @GetMapping(value = "userName/{name}")
    public User nameBase(@PathVariable String name) {
        return userService.nameInBases(name);
    }

    @GetMapping(value = "user/randomJoke/{name}")
    public String randomJoke(@PathVariable String name) throws BadApiRequestException {
        return userService.randomJoke(name);
    }
}
