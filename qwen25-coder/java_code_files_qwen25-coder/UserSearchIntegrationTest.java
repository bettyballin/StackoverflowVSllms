import java.lang.String;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;

public class UserSearchIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUserSearchIntegration() throws Exception {
        mockMvc.perform(get("/users/search?name=John"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("John")));
    }
}

public class Main {
    public static void main(String[] args) {
    }
}