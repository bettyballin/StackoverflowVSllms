public class UnitOfWork : IUnitOfWork\n{\n    private readonly ISession _session;\n    private ITransaction _transaction;\n\n    public UnitOfWork(ISession session)\n    {\n        _session = session ?? throw new ArgumentNullException(nameof(session), "Session cannot be null.");\n    }\n\n    public void Begin()\n    {\n        _transaction = _session.BeginTransaction();\n    }\n\n    public void Commit()\n    {\n        try\n        {\n            if (_transaction?.IsActive == true)\n                _transaction.Commit();\n        }\n        catch\n        {\n            _transaction.Rollback();\n            throw;\n        }\n        finally\n        {\n            CloseSession();\n        }\n    }\n\n    private void CloseSession()\n    {\n        if (_session.IsOpen)\n            _session.Close();\n\n        _transaction?.Dispose();\n    }\n\n    public void Dispose()\n    {\n        try\n        {\n            _transaction?.Rollback();\n        }\n        catch (ObjectDisposedException)\n        {\n            // transaction is already disposed, so we can ignore the exception\n        }\n        finally\n        {\n            CloseSession();\n        }\n    }\n}