using System.Data.Entity;\n\n   public class MyDbContext : DbContext\n   {\n       public DbSet<Product> Products { get; set; }\n\n       protected override void OnModelCreating(DbModelBuilder modelBuilder)\n       {\n           // Configuration goes here if needed\n       }\n   }