public class User\n{\n    public User(int id, string name)\n    {\n        Id = id;\n        Name = name;\n    }\n\n    public int Id { get; }\n    public string Name { get; }\n}\n\n// In your DbContext\nprotected override void OnModelCreating(ModelBuilder modelBuilder)\n{\n    modelBuilder.Entity<User>().HasConstructor((int id, string name) => new User(id, name));\n}