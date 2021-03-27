package pl.skorupska.woodpeckertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skorupska.woodpeckertask.user.User;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public int countAllUser() {
        return userRepo.count();
    }

    public long numberOfUserAboveAge(int age) {
        return userRepo.numberOfUserAboveAge(age);
    }

    public double averageAge() throws Exception {
        return userRepo.averageAge();
    }

    public Set<String> listOfAllHobbies() {
        return userRepo.listOfAllHobbies();
    }

    public List<String> allNamesInFile() {
        return userRepo.allNamesInFile();
    }

    public User getNameFromFile(String name) {
        return userRepo.getNameFromFile(name);
    }
}
