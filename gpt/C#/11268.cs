public class UserService : IUserService\n{\n    public UserDTO GetUser(int userId)\n    {\n        // Fetch the domain object from the database or other source\n        User user = GetUserFromDatabase(userId);\n\n        // Map the domain object to the DTO\n        return new UserDTO\n        {\n            Id = user.Id,\n            Name = user.Name,\n            Email = user.Email\n        };\n    }\n\n    private User GetUserFromDatabase(int userId)\n    {\n        // Placeholder for actual data fetching logic\n        return new User { Id = userId, Name = "John Doe", Email = "john.doe@example.com" };\n    }\n}