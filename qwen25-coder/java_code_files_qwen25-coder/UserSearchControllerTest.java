import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserSearchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUserSearch() throws Exception {
        mockMvc.perform(get("/users/search?name=John"))
               .andExpect(status().isOk())
               .andExpect(view().name("userList"));
    }

    public static void main(String[] args) {
    }
}