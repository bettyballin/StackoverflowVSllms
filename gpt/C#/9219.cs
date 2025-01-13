public class Product\n   {\n       public int ProductId { get; set; }\n       public string Name { get; set; }\n       public decimal Price { get; set; }\n   }\n\n   public class ApplicationDbContext : DbContext\n   {\n       public DbSet<Product> Products { get; set; }\n   }