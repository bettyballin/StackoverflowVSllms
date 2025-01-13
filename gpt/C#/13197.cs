public interface IUnitOfWork : IDisposable\n{\n    ISession Session { get; }\n    void Commit();\n    void Rollback();\n}