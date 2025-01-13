// Example of Unit of Work with NHibernate\npublic class UnitOfWork : IDisposable\n{\n    private ITransaction _transaction;\n    private readonly ISession _session;\n\n    public UnitOfWork(ISession session)\n    {\n        _session = session;\n        _transaction = session.BeginTransaction();\n    }\n\n    public void Commit()\n    {\n        try\n        {\n            _transaction.Commit();\n        }\n        catch\n        {\n            _transaction.Rollback();\n            throw;\n        }\n        finally\n        {\n            _transaction.Dispose();\n            _transaction = null;\n        }\n    }\n\n    public void Dispose()\n    {\n        if (_transaction != null)\n        {\n            _transaction.Rollback();\n            _transaction.Dispose();\n        }\n\n        _session.Dispose();\n    }\n}