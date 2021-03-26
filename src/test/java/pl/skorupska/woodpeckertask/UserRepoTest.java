package pl.skorupska.woodpeckertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepoTest {
    private UserRepo userRepo;

    @Autowired
    public UserRepoTest(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
