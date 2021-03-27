package pl.skorupska.woodpeckertask;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    UserRepository userRepo;

    @Test
    public void testCountAllUser() {
        //Given
        int user = 1;
        when(userRepo.count()).thenReturn(user);

        //When
        int i = userService.countAllUser();

        //than
        assertEquals(1, i);
    }

    @Test
    public void testNumberOfUserAboveAge() {
        //Given
        long user = 1;
        when(userRepo.numberOfUserAboveAge(10)).thenReturn(user);

        //When
        long i = userService.numberOfUserAboveAge(10);

        //than
        assertEquals(1, i);
    }

    @Test
    public void testAverageAge() throws Exception {
        //Given
        double user = 25;
        when(userRepo.averageAge()).thenReturn(user);

        //When
        double i = userService.averageAge();

        //than
        assertEquals(25, i);
    }

    @Test
    public void testListAllHobby() {
        //Given
        Set<String> hobby = new HashSet<>();
        hobby.add("Sport");
        hobby.add("Music");
        when(userRepo.listHobbyAll()).thenReturn(hobby);

        //When
        Set<String> list = userService.listHobbyAll();

        //than
        assertEquals(hobby, list);
    }

    @Test
    public void testAllNameForBases() {
        //Given
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Tom");
        when(userRepo.allNameForBases()).thenReturn(names);

        //When
        List<String> list = userService.allNameOfBases();

        //than
        assertEquals(names, list);
    }

//    @Test
//    public void testGetNameInBase() {
//        //Given
//        User user = new User("Anna", 20, null);
//        when(userRepo.getNameInBase(user.getName())).thenReturn(user);
//
//        //When
//        User test = userService.nameInBases("Anna");
//
//        //than
//        assertEquals("Anna", test);
//    }
//
//
//
//    private String jsonTxt = "{\"type\": \"success\", \"value\": {\"id\": 451, \"joke\": \"Xav Ducrohet writes code that optimizes itself.\"]}}";
//
//    @Test
//    public void testGetJoke() throws Exception {
//        Gson gson = new Gson();
//        Joke jokeResponse = gson.fromJson(jsonTxt, Joke.class);
//        String correct = "Xav Ducrohet writes code that optimizes itself.";
//        assertNotNull(jokeResponse);
//        assertEquals(correct, jokeResponse.getJoke());
//    }

}
