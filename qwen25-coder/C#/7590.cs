using System;\nusing System.Linq;\nusing Microsoft.EntityFrameworkCore;\n\nclass YourDbContext : DbContext\n{\n    public DbSet<YourModel> YourModels { get; set; }\n\n    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)\n    {\n        optionsBuilder.UseSqlServer("YourConnectionString");\n    }\n}\n\npublic class YourModel\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n    // More properties based on your view columns\n}\n\nclass Program\n{\n    static void Main()\n    {\n        using (var context = new YourDbContext())\n        {\n            var result = context.YourModels.Where(m => m.Name == "YourValue").ToList();\n\n            foreach (var item in result)\n            {\n                Console.WriteLine(item);\n            }\n        }\n    }\n}