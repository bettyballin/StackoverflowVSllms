public class MyDbContext : DbContext\n{\n    public MyDbContext(DbContextOptions<MyDbContext> options) : base(options) { }\n\n    // DbSets for your entities\n    public DbSet<Contact> Contacts { get; set; }\n}