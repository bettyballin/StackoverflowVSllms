public interface IUnitOfWork : IDisposable\n{\n    void BeginTransaction();\n    void Commit();\n    void Rollback();\n}\n\npublic class EntityFrameworkUnitOfWork : IUnitOfWork\n{\n    private readonly DbContext _context;\n    private IDbTransaction _transaction;\n\n    public EntityFrameworkUnitOfWork(DbContext context)\n    {\n        _context = context;\n    }\n\n    public void BeginTransaction()\n    {\n        _transaction = _context.Database.BeginTransaction();\n    }\n\n    public void Commit()\n    {\n        _transaction.Commit();\n    }\n\n    public void Rollback()\n    {\n        _transaction.Rollback();\n    }\n\n    public void Dispose()\n    {\n        _transaction.Dispose();\n    }\n}