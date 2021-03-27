package pl.skorupska.woodpeckertask;

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
        when(userRepo.listOfAllHobbies()).thenReturn(hobby);

        //When
        Set<String> list = userService.listOfAllHobbies();

        //than
        assertEquals(hobby, list);
    }

    @Test
    public void testAllNameForBases() {
        //Given
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Tom");
        when(userRepo.allNamesInFile()).thenReturn(names);

        //When
        List<String> list = userService.allNamesInFile();

        //than
        assertEquals(names, list);
    }
}
