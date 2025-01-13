// IGenericRepository.cs\npublic interface IGenericRepository<T> where T : class\n{\n    Task<IEnumerable<T>> GetAll();\n    Task<T> GetById(int id);\n    Task Add(T entity);\n    Task Update(T entity);\n    Task Delete(int id);\n}\n\n// GenericRepository.cs\npublic class GenericRepository<T> : IGenericRepository<T> where T : class\n{\n    private readonly DbContext _context;\n    private readonly DbSet<T> _dbSet;\n\n    public GenericRepository(DbContext context)\n    {\n        _context = context;\n        _dbSet = context.Set<T>();\n    }\n\n    public async Task<IEnumerable<T>> GetAll()\n    {\n        return await _dbSet.ToListAsync();\n    }\n\n    public async Task<T> GetById(int id)\n    {\n        return await _dbSet.FindAsync(id);\n    }\n\n    public async Task Add(T entity)\n    {\n        await _dbSet.AddAsync(entity);\n        await _context.SaveChangesAsync();\n    }\n\n    public async Task Update(T entity)\n    {\n        _dbSet.Attach(entity);\n        _context.Entry(entity).State = EntityState.Modified;\n        await _context.SaveChangesAsync();\n    }\n\n    public async Task Delete(int id)\n    {\n        var entity = await _dbSet.FindAsync(id);\n        _dbSet.Remove(entity);\n        await _context.SaveChangesAsync();\n    }\n}\n\n// UnitOfWork.cs\npublic class UnitOfWork : IUnitOfWork\n{\n    private readonly DbContext _context;\n\n    public UnitOfWork(DbContext context)\n    {\n        _context = context;\n    }\n\n    public async Task Complete()\n    {\n        await _context.SaveChangesAsync();\n    }\n}\n\n// IUnitOfWork.cs\npublic interface IUnitOfWork\n{\n    Task Complete();\n}