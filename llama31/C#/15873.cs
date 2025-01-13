// Domain model\npublic class User\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n}\n\n// Repository interface\npublic interface IUserRepository\n{\n    User GetById(int id);\n    void Save(User user);\n}\n\n// Entity Framework repository implementation\npublic class EFUserRepository : IUserRepository\n{\n    private readonly DbContext _context;\n\n    public EFUserRepository(DbContext context)\n    {\n        _context = context;\n    }\n\n    public User GetById(int id)\n    {\n        return _context.Users.Find(id);\n    }\n\n    public void Save(User user)\n    {\n        _context.Users.AddOrUpdate(user);\n        _context.SaveChanges();\n    }\n}\n\n// File system repository implementation (for unit testing)\npublic class FileSystemUserRepository : IUserRepository\n{\n    private readonly string _filePath;\n\n    public FileSystemUserRepository(string filePath)\n    {\n        _filePath = filePath;\n    }\n\n    public User GetById(int id)\n    {\n        // Read from file system\n        // ...\n    }\n\n    public void Save(User user)\n    {\n        // Write to file system\n        // ...\n    }\n}