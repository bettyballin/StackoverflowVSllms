public class UserService\n   {\n       private readonly ApplicationDbContext _context;\n\n       public UserService(ApplicationDbContext context)\n       {\n           _context = context;\n       }\n\n       public async Task<List<User>> GetUsersAsync()\n       {\n           return await _context.Users.ToListAsync();\n       }\n\n       public async Task AddUserAsync(User user)\n       {\n           _context.Users.Add(user);\n           await _context.SaveChangesAsync();\n       }\n\n       public async Task UpdateUserAsync(User user)\n       {\n           _context.Users.Update(user);\n           await _context.SaveChangesAsync();\n       }\n\n       public async Task DeleteUserAsync(int id)\n       {\n           var user = await _context.Users.FindAsync(id);\n           if (user != null)\n           {\n               _context.Users.Remove(user);\n               await _context.SaveChangesAsync();\n           }\n       }\n   }