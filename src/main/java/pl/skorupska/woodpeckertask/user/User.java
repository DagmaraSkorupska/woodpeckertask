package pl.skorupska.woodpeckertask.user;

import java.util.List;

public class User {
    private String name;
    private Integer age;
    private List<String> hobbyList;

    public User(String name, Integer age, List<String> hobbyList) {
        this.name = name;
        this.age = age;
        this.hobbyList = hobbyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<String> hobbyList) {
        this.hobbyList = hobbyList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbyList=" + hobbyList +
                '}';
    }
}
