public class MyEntity\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n    public bool IsLatest { get; set; }\n    public int VersionId { get; set; }\n}\n\npublic class MyDbContext : DbContext\n{\n    public DbSet<MyEntity> MyEntities { get; set; }\n\n    protected override void OnModelCreating(ModelBuilder modelBuilder)\n    {\n        modelBuilder.Entity<MyEntity>()\n            .Property(e => e.IsLatest)\n            .HasDefaultValue(true);\n\n        modelBuilder.Entity<MyEntity>()\n            .Property(e => e.VersionId)\n            .HasDefaultValue(1);\n    }\n}