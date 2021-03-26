package pl.skorupska.woodpeckertask;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Joke {

//    public static final String ENDPOINT_URL = "http://api.icndb.com/jokes/";


    public String jokeGet(){
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> exchange = rest.exchange(
                "http://api.icndb.com/jokes/",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class);
        return exchange.getBody();
    }
}
