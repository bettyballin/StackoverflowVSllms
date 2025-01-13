using Microsoft.EntityFrameworkCore;\n\npublic class MyDbContext : DbContext\n{\n    public DbSet<Product> Products { get; set; }\n\n    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)\n    {\n        optionsBuilder.UseSqlServer(@"Server=(localdb)\mssqllocaldb;Database=MyDatabase;Trusted_Connection=True;");\n    }\n}\n\npublic class Product\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n    public decimal Price { get; set; }\n}