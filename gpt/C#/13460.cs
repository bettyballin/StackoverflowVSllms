// Define a generic repository interface\npublic interface IRepository<T>\n{\n    Task<IEnumerable<T>> GetAllAsync();\n    Task<T> GetByIdAsync(int id);\n    Task AddAsync(T entity);\n    Task UpdateAsync(T entity);\n    Task DeleteAsync(int id);\n}\n\n// Implement a repository for SQL Server\npublic class SqlRepository<T> : IRepository<T>\n{\n    private readonly DbContext _context;\n\n    public SqlRepository(DbContext context)\n    {\n        _context = context;\n    }\n\n    public async Task<IEnumerable<T>> GetAllAsync()\n    {\n        return await _context.Set<T>().ToListAsync();\n    }\n\n    public async Task<T> GetByIdAsync(int id)\n    {\n        return await _context.Set<T>().FindAsync(id);\n    }\n\n    public async Task AddAsync(T entity)\n    {\n        await _context.Set<T>().AddAsync(entity);\n        await _context.SaveChangesAsync();\n    }\n\n    public async Task UpdateAsync(T entity)\n    {\n        _context.Set<T>().Update(entity);\n        await _context.SaveChangesAsync();\n    }\n\n    public async Task DeleteAsync(int id)\n    {\n        var entity = await _context.Set<T>().FindAsync(id);\n        if (entity != null)\n        {\n            _context.Set<T>().Remove(entity);\n            await _context.SaveChangesAsync();\n        }\n    }\n}\n\n// Configuration service to handle connection strings\npublic class ConfigurationService\n{\n    private readonly IConfiguration _configuration;\n\n    public ConfigurationService(IConfiguration configuration)\n    {\n        _configuration = configuration;\n    }\n\n    public string GetConnectionString(bool isLocal)\n    {\n        return isLocal ? _configuration.GetConnectionString("LocalDB") : _configuration.GetConnectionString("RemoteDB");\n    }\n}\n\n// Example usage in a startup class\npublic class Startup\n{\n    public void ConfigureServices(IServiceCollection services)\n    {\n        var isLocal = true; // This can be set based on environment or configuration\n        var configurationService = new ConfigurationService(Configuration);\n        var connectionString = configurationService.GetConnectionString(isLocal);\n\n        services.AddDbContext<MyDbContext>(options => options.UseSqlServer(connectionString));\n        services.AddScoped(typeof(IRepository<>), typeof(SqlRepository<>));\n    }\n}