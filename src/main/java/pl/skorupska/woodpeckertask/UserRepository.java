package pl.skorupska.woodpeckertask;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.stereotype.Repository;
import pl.skorupska.woodpeckertask.exception.AverageException;
import pl.skorupska.woodpeckertask.exception.UserNotFoundException;
import pl.skorupska.woodpeckertask.user.User;
import pl.skorupska.woodpeckertask.user.UserData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() throws FileNotFoundException {
        Set<String> validHobbySet = Stream
                .of("Sports", "Gaming", "Traveling", "Movies", "Music", "Cooking", "Reading", "Dancing")
                .collect(Collectors.toCollection(HashSet::new));

        Properties prop = new Properties();
        String filePath;
        try {
            prop.load(WoodpeckerTaskApplication.class.getClassLoader().getResourceAsStream("application.properties"));
            filePath = prop.getProperty("path");
        } catch (IOException e) {
            System.out.println("Can't read properties file");
            return;
        }

        List<UserData> userDataList = new CsvToBeanBuilder<UserData>(new FileReader(filePath))
                .withType(UserData.class)
                .withSeparator(',')
                .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                .build()
                .parse();
        Map<String, List<UserData>> map = userDataList.stream()
                .filter(userData -> (emptyAgeFilter(userData.getAge()) && hobbyFilter(userData.getHobby(), validHobbySet)))
                .collect(groupingBy(UserData::getName));

        for (Map.Entry<String, List<UserData>> entry : map.entrySet()) {
            List<String> hobbies = entry.getValue().stream().map(UserData::getHobby).collect(Collectors.toList());
            Integer age = entry.getValue().get(0).getAge();
            User user = new User(entry.getKey(), age, hobbies);
            users.add(user);
        }
    }

    private static boolean emptyAgeFilter(Integer userAge) {
        return userAge != null;
    }

    private static boolean hobbyFilter(String hobby, Set<String> validHobbyList) {
        return validHobbyList.contains(hobby);
    }

    public int count() {
        return users.size();
    }

    public long numberOfUserAboveAge(int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .count();
    }

    public double averageAge() throws AverageException {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElseThrow(AverageException::new);
    }

    public Set<String> listOfAllHobbies() {
        return users.stream()
                .flatMap(user -> user.getHobbyList().stream())
                .collect(Collectors.toSet());
    }

    public List<String> allNamesInFile() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public User getNameFromFile(String name) throws UserNotFoundException {
        return users.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(name));
    }

    @Override
    public String toString() {
        return "UserRepo{" +
                "users=" + users +
                '}';
    }
}

