import java.lang.String;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MyControllerTests_1 {
    // Example of using MockMvc for testing a REST endpoint
    @WebMvcTest
    class MyControllerTests {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void testGetEndpoint() throws Exception {
            this.mockMvc.perform(get("/api/data"))
                        .andExpect(status().isOk())
                        .andExpect(content().string("Test"));
        }
    }

    public static void main(String[] args) {
    }
}