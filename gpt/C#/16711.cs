using System;\nusing System.Linq;\nusing Microsoft.EntityFrameworkCore;\n\npublic class UserContext : DbContext\n{\n    public DbSet<User> Users { get; set; }\n}\n\npublic class UserRepository\n{\n    private readonly UserContext _context;\n\n    public UserRepository(UserContext context)\n    {\n        _context = context;\n    }\n\n    public void AddUser(User user)\n    {\n        _context.Users.Add(user);\n        _context.SaveChanges();\n    }\n\n    public User GetUser(int id)\n    {\n        return _context.Users.Find(id);\n    }\n}