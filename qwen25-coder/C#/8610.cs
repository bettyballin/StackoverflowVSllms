public class ApplicationDbContext : DbContext\n{\n    public DbSet<YourEntity> YourTable { get; set; }\n}\n\npublic class YourEntity\n{\n    [Key]\n    public int Id { get; set; }\n\n    public string YourFieldName { get; set; }\n}