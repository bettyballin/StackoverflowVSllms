using Microsoft.EntityFrameworkCore;\nusing System.Linq;\n\npublic class MyDbContext : DbContext\n{\n    public DbSet<MyEntity> MyEntities { get; set; }\n\n    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)\n    {\n        optionsBuilder.UseSqlServer(@"Data Source=mydbserver;Initial Catalog=mydatabase;Integrated Security=True");\n    }\n}\n\npublic class MyEntity\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n}\n\npublic class MyService\n{\n    private readonly MyDbContext _context;\n\n    public MyService(MyDbContext context)\n    {\n        _context = context;\n    }\n\n    public async Task<MyEntity> GetEntityAsync(int id)\n    {\n        return await _context.MyEntities.FindAsync(id);\n    }\n}