using System.Data.Entity;\n\n   public class MyDbContext : DbContext\n   {\n       public DbSet<Product> Products { get; set; }\n   }