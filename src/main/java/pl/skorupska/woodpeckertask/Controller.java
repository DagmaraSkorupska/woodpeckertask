package pl.skorupska.woodpeckertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.skorupska.woodpeckertask.exception.BadApiRequestException;
import pl.skorupska.woodpeckertask.joke.DownloadJoke;
import pl.skorupska.woodpeckertask.user.User;

import java.util.List;
import java.util.Set;

@RestController
public class Controller {

    private final UserService userService;
    private final DownloadJoke downloadJoke;

    @Autowired
    public Controller(UserService userService, DownloadJoke downloadJoke) {
        this.userService = userService;
        this.downloadJoke = downloadJoke;
    }

    @GetMapping(value = "/users/count")
    public int userCount() {
        return userService.countAllUser();
    }

    @GetMapping(value = "users/ageAbove/{age}")
    public long numberOfUserAboveAge(@PathVariable int age) {
        return userService.numberOfUserAboveAge(age);
    }

    @GetMapping(value = "users/averageAge")
    public double averageAge() throws Exception {
        return userService.averageAge();
    }

    @GetMapping(value = "users/hobbies")
    public Set<String> listOfAllHobbies() {
        return userService.listOfAllHobbies();
    }

    @GetMapping(value = "users/names")
    public List<String> allNamesInFile() {
        return userService.allNamesInFile();
    }

    @GetMapping(value = "user/byName/{name}")
    public User getNameFromFile(@PathVariable String name) {
        return userService.getNameFromFile(name);
    }

    @GetMapping(value = "user/joke/{name}")
    public String randomJoke(@PathVariable String name) throws BadApiRequestException {
        return downloadJoke.randomJoke(name);
    }
}
