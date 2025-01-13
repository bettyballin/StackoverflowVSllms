public class MyDbContext : DbContext\n   {\n       public DbSet<MyModel> MyModels { get; set; }\n\n       protected override void OnConfiguring(DbContextOptionsBuilder options)\n           => options.UseSqlServer("YourConnectionStringHere");\n   }\n\n   public class MyModel\n   {\n       public int Id { get; set; }\n       public string Name { get; set; }\n   }