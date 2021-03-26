package pl.skorupska.woodpeckertask;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Repository
public class UserRepo {

    private final List<User1> users = new ArrayList<>();

    public UserRepo() throws FileNotFoundException {
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

        List<UserData> personDataList = new CsvToBeanBuilder<UserData>(new FileReader(filePath))
                .withType(UserData.class)
                .withSeparator(',')
                .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                .build()
                .parse();
        Map<String, List<UserData>> map = personDataList.stream()
                .filter(person -> (emptyAgeFilter(person.getAge()) && hobbyFilter(person.getHobby(), validHobbySet)))
                .collect(groupingBy(UserData::getName));

        for (Map.Entry<String, List<UserData>> entry : map.entrySet()) {
            List<String> hobbies = entry.getValue().stream().map(UserData::getHobby).collect(Collectors.toList());
            Integer age = entry.getValue().get(0).getAge();
            User1 personEntity = new User1(entry.getKey(), age, hobbies);
            users.add(personEntity);
        }
        System.out.println(users);
    }

    private static boolean emptyAgeFilter(Integer personAge) {
        return personAge != null;
    }

    private static boolean hobbyFilter(String hobby, Set<String> validHobbyList) {
        return validHobbyList.contains(hobby);
    }


    public void add(User1 user) {
        this.users.add(user);
    }

    public int count() {
        return users.size();
    }

    public long numberOfPersonsAboveAge(int age) {
        return users.stream()
                .filter(user1 -> user1.getAge() > age)
                .count();
    }

    public double averageAge() throws Exception {
        return users.stream()
                .mapToInt(User1::getAge)
                .average().orElseThrow(Exception::new);
    }

    public Set<String> listHobbyAll() {
        return users.stream()
                .flatMap(user1 -> user1.getHobbyList().stream())
                .collect(Collectors.toSet());
    }


//    public boolean nameForBase(String name){
//        return users.stream()
//                .filter(user1 -> user1.getName().equals(name))
//                .collect();
//    }



    @Override
    public String toString() {
        return "UserRepo{" +
                "users=" + users +
                '}';
    }
}
