import java.lang.String;

// Remove package prefixes from the imports and annotations
import static SecurityMockMvcRequestPostProcessors.*;
import static MockMvcRequestBuilders.*;
import static MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MyController.class)
public class MyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    // Test with anonymous user
    @Test
    public void shouldReturnDefaultMessageForAnonymousUser() throws Exception {
        mockMvc.perform(get("/faqs"))
                .andExpect(status().isOk())
                .andExpect(content().string("FAQ Content"));
    }

    // Test with authenticated user
    @WithMockUser(username = "testuser", roles = "USER")
    @Test
    public void shouldReturnUserDetails() throws Exception {
        mockMvc.perform(get("/accountDetail"))
               .andExpect(status().isOk())
               .andExpect(content().string("Account details for testuser"));
    }

    public static void main(String[] args) {
    }
}

// Necessary supporting annotations and classes.

@interface RunWith {
    Class<?> value();
}

@interface WebMvcTest {
    Class<?>[] value() default {};
}

@interface WithMockUser {
    String username() default "";
    String[] roles() default {};
}

@interface Autowired {
}

@interface Test {
}

class SpringRunner {
}

class MyController {
}

class MockMvc {
    public ResultActions perform(RequestBuilder requestBuilder) {
        return new ResultActions();
    }
}

class ResultActions {
    public ResultActions andExpect(ResultMatcher matcher) {
        return this;
    }
}

interface RequestBuilder {
}

interface ResultMatcher {
}

class MockMvcRequestBuilders {
    public static RequestBuilder get(String url) {
        return new RequestBuilder() {};
    }
}

class MockMvcResultMatchers {
    public static StatusResultMatchers status() {
        return new StatusResultMatchers();
    }

    public static ContentResultMatchers content() {
        return new ContentResultMatchers();
    }
}

class StatusResultMatchers {
    public ResultMatcher isOk() {
        return new ResultMatcher() {};
    }
}

class ContentResultMatchers {
    public ResultMatcher string(String content) {
        return new ResultMatcher() {};
    }
}

class SecurityMockMvcRequestPostProcessors {
    // Empty class; no methods used in this code.
}