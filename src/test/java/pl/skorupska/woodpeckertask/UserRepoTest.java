package pl.skorupska.woodpeckertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepoTest {
    private UserRepository userRepo;

    @Autowired
    public UserRepoTest(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
}
