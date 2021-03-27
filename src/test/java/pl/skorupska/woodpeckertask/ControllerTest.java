package pl.skorupska.woodpeckertask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.skorupska.woodpeckertask.exception.BadApiRequestException;

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
public class ControllerTest {

    private MockMvc mockMvc;

    @Autowired
    public ControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @MockBean
    private UserService userService;

    @Test
    public void shouldUserCount() throws Exception {
        //Given
        when(userService.countAllUser()).thenReturn(1);
        //When&Then
        mockMvc.perform(get("/userCount")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    @Test
    public void shouldNumberOfUser() throws Exception {
        //Given
        long user = 25;
        when(userService.numberOfUserAboveAge(10)).thenReturn(user);
        //When&Then
        mockMvc.perform(get("/userAge/10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAverageAge() throws Exception {
        //Given
        double user = 25;
        when(userService.averageAge()).thenReturn(user);
        //When&Then
        mockMvc.perform(get("/userAverage")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldListAllHobby() throws Exception {
        //Given
        Set<String> hobby = new HashSet<>();
        hobby.add("Sport");
        hobby.add("Music");
        when(userService.listHobbyAll()).thenReturn(hobby);
        //When&Then
        mockMvc.perform(get("/userAllHobby")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAllNameOfBases() throws Exception {
        //Given
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Tom");
        when(userService.allNameOfBases()).thenReturn(names);
        //When&Then
        mockMvc.perform(get("/userAllName")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNameOfBase() throws Exception {
        //Given
        List<String> hobby = new ArrayList<>();
        hobby.add("Sport");
        hobby.add("Music");
        User user = new User("Anna", 20, hobby);
        when(userService.nameInBases("Anna")).thenReturn(user);
        //When&Then
        mockMvc.perform(get("/userName/Anna")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())

                .andExpect(jsonPath("$.name", is("Anna")))
                .andExpect(jsonPath("$.age", is(20)))
                .andExpect(jsonPath("$.hobbyList[0]", is("Sport")))
                .andExpect(jsonPath("$.hobbyList[1]", is("Music")));
    }
}
