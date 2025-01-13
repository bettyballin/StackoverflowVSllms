public class UserService\n    {\n        private readonly ApplicationDbContext _context;\n\n        public UserService(ApplicationDbContext context)\n        {\n            _context = context;\n        }\n\n        public User GetUserById(int userId)\n        {\n            return _context.Users.FirstOrDefault(u => u.Id == userId);\n        }\n\n        public void UpdateUser(User user)\n        {\n            _context.Users.Update(user);\n            _context.SaveChanges();\n        }\n    }