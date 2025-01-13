using Microsoft.EntityFrameworkCore;\nusing System.Linq;\n\npublic class MyDbContext : DbContext\n{\n    public DbSet<MyEntity> MyEntities { get; set; }\n}\n\npublic class MyEntity\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n}\n\n// Retrieve data from the database\nusing (var dbContext = new MyDbContext())\n{\n    var myEntities = dbContext.MyEntities.ToList();\n    foreach (var entity in myEntities)\n    {\n        Console.WriteLine(entity.Name);\n    }\n}