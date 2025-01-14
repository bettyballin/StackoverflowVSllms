@interface Controller {}
@interface RequestMapping {
    String value() default "";
}
@interface RequestParam {
    String value() default "";
}
@interface Positive {}
@interface ConstructorProperties {
    String[] value();
}

class BindingResult {
    public boolean hasErrors() {
        return false;
    }
}

class ModelAndView {
    public ModelAndView(String viewName) {}
    public void addObject(String attributeName, Object attributeValue) {}
}

class UserProfileService {
    public UserProfile getUserProfileById(int userId) {
        return null;
    }
}

class UserProfile {}

@Controller
public class ProfileController {

    private final UserProfileService userProfileService;

    @ConstructorProperties({"userProfileService"})
    public ProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @RequestMapping("/profile.html")
    public ModelAndView showUserProfile(@RequestParam("id") @Positive int userId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("errorMessage", "Invalid user ID provided.");
            return modelAndView;
        }

        UserProfile userProfile = userProfileService.getUserProfileById(userId);
        if (userProfile == null) {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("errorMessage", "User profile not found.");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("userProfile", userProfile);
        return modelAndView;
    }

    public static void main(String[] args) {
    }
}