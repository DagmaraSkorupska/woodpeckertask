package pl.skorupska.woodpeckertask;

import java.util.List;


public class User1 {
    private String name;
    private Integer age;
    private List<String> hobbyList;

    public User1(String name, Integer age, List<String> hobbyList) {
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
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbyList=" + hobbyList +
                '}';
    }

}
