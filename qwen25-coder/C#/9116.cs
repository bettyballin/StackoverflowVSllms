// Data Access Layer (DAL)\npublic class UserRepository\n{\n    public User GetUserById(int id)\n    {\n        // Database query to get user by ID\n    }\n}\n\n// Business Logic Layer (BLL)\npublic class UserService\n{\n    private readonly UserRepository _userRepository;\n\n    public UserService(UserRepository userRepository)\n    {\n        _userRepository = userRepository;\n    }\n\n    public bool IsUserActive(int userId)\n    {\n        var user = _userRepository.GetUserById(userId);\n        // Business logic to determine if user is active\n        return user != null && user.IsActive;\n    }\n}