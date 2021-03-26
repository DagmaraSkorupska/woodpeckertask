package pl.skorupska.woodpeckertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

    public long numberOfPersonsAboveAge(int age){
        return userRepo.numberOfPersonsAboveAge(age);
    }

    public double averageAge() throws Exception {
        return userRepo.averageAge();
    }


    public Set<String> listHobbyAll(){
        return userRepo.listHobbyAll();
    }

    public boolean name(String name){
        return userRepo.equals(name);
    }





    public void rest(String host, String port, String infoToSent){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(
                String.format("http://api.icndb.com/jokes/", host, port, infoToSent),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class);
    }

    RestTemplate restTemplate = new RestTemplate();
    String baseURL = "http://api.icndb.com/jokes/";


}
