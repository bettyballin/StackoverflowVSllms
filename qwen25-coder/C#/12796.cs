using System;\n   using System.Linq;\n   using Microsoft.EntityFrameworkCore;\n\n   public class MyDbContext : DbContext\n   {\n       public DbSet<User> Users { get; set; }\n       public DbSet<Post> Posts { get; set; }\n\n       protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)\n       {\n           optionsBuilder.UseSqlServer("YourConnectionString");\n       }\n   }\n   \n   // Usage example:\n   using (var context = new MyDbContext())\n   {\n       var posts = context.Posts.Include(p => p.Author).ToList();\n   }