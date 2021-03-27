package pl.skorupska.woodpeckertask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {
    private UserRepository userRepo;

    @Autowired
    public UserRepositoryTest(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
}
