public class YourDbContext : DbContext\n{\n    private readonly ILoggerFactory _loggerFactory;\n\n    public YourDbContext(DbContextOptions<YourDbContext> options, ILoggerFactory loggerFactory)\n        : base(options)\n    {\n        _loggerFactory = loggerFactory;\n    }\n\n    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)\n    {\n        optionsBuilder\n            .UseSqlServer("YourConnectionString")\n            .UseLoggerFactory(_loggerFactory); // Use the configured logger\n    }\n}