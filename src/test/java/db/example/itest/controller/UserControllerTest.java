package db.example.itest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import db.example.controller.UserController;
import db.example.remote.dom.Address;
import db.example.remote.dom.Company;
import db.example.remote.dom.GeoLocation;
import db.example.remote.dom.User;
import db.example.remote.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @LocalServerPort
    private static int port;
    private static String serverUrl;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @BeforeAll
    static void setUp() {
        serverUrl = "http://localhost:" + port;

        var principal = new UsernamePasswordAuthenticationToken("testuser", "testpassword");
        SecurityContextHolder.getContext().setAuthentication(principal);
    }

    @AfterAll
    static void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void testGetUser() throws Exception {
        final var expectedUser = expectedUser(1);

        when(userService.getUser(anyLong())).thenReturn(expectedUser);

        final var response = mockMvc.perform(get(serverUrl + "/users/" + expectedUser.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        final var actualUser = objectMapper.readValue(response.getResponse().getContentAsString(), User.class);

        assertEquals(expectedUser(1), actualUser);
    }

    private User expectedUser(long id) {
        return User.builder()
                .id(id)
                .name("abc " + id)
                .username("abcdef" + id)
                .email("abc@def.com")
                .phone("123-456-789")
                .website("abcdef.com")
                .address(Address.builder()
                        .street("qwe")
                        .suite("12")
                        .city("qwe")
                        .zipcode("123456")
                        .geoLocation(GeoLocation.builder().latitude(-12.35).longitude(-45.67).build())
                        .build())
                .company(Company.builder().name("qwerty").catchPhrase("qwert yuiop").bs("asdfgh").build())
                .build();
    }
}
