public class UserService {\n    private final UserValidator validator;\n\n    public UserService(UserValidator validator) {\n        this.validator = validator;\n    }\n\n    public User CreateUser(String username, String password, UserDetails details) {\n        validator.ValidateUserDetails(details);\n        validator.ValidateUsername(username);\n        validator.ValidatePassword(password);\n\n        // create and return user\n    }\n}\n\npublic class UserValidator {\n    public void ValidateUserDetails(UserDetails details) {\n        // validation logic\n    }\n\n    public void ValidateUsername(String username) {\n        // validation logic\n    }\n\n    public void ValidatePassword(String password) {\n        // validation logic\n    }\n}