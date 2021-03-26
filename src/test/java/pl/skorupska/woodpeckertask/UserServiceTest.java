package pl.skorupska.woodpeckertask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    UserRepo userRepo;

    @Test
    public void testCountAllUser(){
        //Given
//        User user = new User("Name", 20, null);
//        when(userRepo.count()).thenReturn(user);

    }

}
