package pl.skorupska.woodpeckertask.joke;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.skorupska.woodpeckertask.user.User;
import pl.skorupska.woodpeckertask.UserRepository;
import pl.skorupska.woodpeckertask.exception.BadApiRequestException;

import java.util.HashMap;
import java.util.Map;

@Component
public class DownloadJoke {

    private final UserRepository userRepo;
    private final RestTemplate restTemplate;
    private static final String url = "http://api.icndb.com/jokes/random?firstName={name}&lastName={age}";


    public DownloadJoke(UserRepository userRepo, RestTemplate restTemplate) {
        this.userRepo = userRepo;
        this.restTemplate = restTemplate;
    }

    public String randomJoke(String name) throws BadApiRequestException {
        User user = userRepo.getNameFromFile(name);
        Map<String, String> vars = new HashMap<>();
        vars.put("name", user.getName());
        vars.put("age", user.getAge().toString());
        JokeResponse jokeResponse = restTemplate.getForObject(url, JokeResponse.class, vars);
        if (jokeResponse == null) {
            throw new BadApiRequestException();
        } else {
            return jokeResponse.getValue().getJoke();
        }
    }
}
