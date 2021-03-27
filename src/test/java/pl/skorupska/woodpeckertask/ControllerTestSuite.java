package pl.skorupska.woodpeckertask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.skorupska.woodpeckertask.joke.DownloadJoke;
import pl.skorupska.woodpeckertask.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
public class ControllerTestSuite {

    private MockMvc mockMvc;

    @Autowired
    public ControllerTestSuite(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @MockBean
    private UserService userService;
    @MockBean
    private DownloadJoke downloadJoke;

    @Test
    public void shouldGetUserCount() throws Exception {
        //Given
        when(userService.countAllUser()).thenReturn(1);
        //When&Then
        mockMvc.perform(get("/users/count")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
    public void shouldGetNumberOfUserAboveAge() throws Exception {
        //Given
        long user = 25;
        when(userService.numberOfUserAboveAge(10)).thenReturn(user);
        //When&Then
        mockMvc.perform(get("/users/ageAbove/10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAverageAge() throws Exception {
        //Given
        double user = 25;
        when(userService.averageAge()).thenReturn(user);
        //When&Then
        mockMvc.perform(get("/users/averageAge")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetListOfAllHobbies() throws Exception {
        //Given
        Set<String> hobby = new HashSet<>();
        hobby.add("Sport");
        hobby.add("Music");
        when(userService.listOfAllHobbies()).thenReturn(hobby);
        //When&Then
        mockMvc.perform(get("/users/hobbies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllNamesInFile() throws Exception {
        //Given
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Tom");
        when(userService.allNamesInFile()).thenReturn(names);
        //When&Then
        mockMvc.perform(get("/users/names")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetNameFromFile() throws Exception {
        //Given
        List<String> hobby = new ArrayList<>();
        hobby.add("Sport");
        hobby.add("Music");
        User user = new User("Anna", 20, hobby);
        when(userService.getNameFromFile("Anna")).thenReturn(user);
        //When&Then
        mockMvc.perform(get("/user/byName/Anna")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())

                .andExpect(jsonPath("$.name", is("Anna")))
                .andExpect(jsonPath("$.age", is(20)))
                .andExpect(jsonPath("$.hobbyList[0]", is("Sport")))
                .andExpect(jsonPath("$.hobbyList[1]", is("Music")));
    }
}
