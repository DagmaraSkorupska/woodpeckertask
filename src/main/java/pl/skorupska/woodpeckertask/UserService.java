package pl.skorupska.woodpeckertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) throws IOException {
        this.userRepo = userRepo;
    }

    public int countAllUser(){
        return userRepo.count();
    }

    public long numberOfUserAboveAge(int age){
        return userRepo.numberOfUserAboveAge(age);
    }

    public double averageAge() throws Exception {
        return userRepo.averageAge();
    }

    public Set<String> listHobbyAll(){
        return userRepo.listHobbyAll();
    }

    public List<String> allNameOfBases(){
        return userRepo.allNameForBases();
    }

    public User nameInBases(String name){
        return userRepo.getNameInBase(name);
    }

    public String randomJoke(String name) throws BadApiRequestException {
        User user = userRepo.getNameInBase(name);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<>();
        vars.put("name", user.getName());
        vars.put("age", user.getAge().toString());
        JokeResponse jokeResponse = restTemplate.getForObject("http://api.icndb.com/jokes/random?firstName={name}&lastName={age}", JokeResponse.class, vars);
        if(jokeResponse == null){
            throw new BadApiRequestException();
        } else {
            return jokeResponse.getValue().getJoke();
        }
    }

}
