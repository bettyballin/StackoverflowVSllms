public class TestUserRepository : IUserRepository\n{\n    private readonly List<User> _users = new List<User>();\n\n    public TestUserRepository()\n    {\n        _users.Add(new User { Id = 1, Name = "John Doe" });\n        _users.Add(new User { Id = 2, Name = "Jane Doe" });\n    }\n\n    public User GetById(int id)\n    {\n        return _users.FirstOrDefault(u => u.Id == id);\n    }\n\n    public IEnumerable<User> GetAll()\n    {\n        return _users;\n    }\n}