public class MyClass\n{\n    private readonly DbContext _dbContext;\n\n    public MyClass(DbContext dbContext)\n    {\n        _dbContext = dbContext;\n    }\n\n    // Property should not perform long-running operation\n    public string SomeProperty { get; set; }\n\n    // Use a method to fetch complex data\n    public async Task<ComplexData> GetComplexDataAsync()\n    {\n        return await _dbContext.ComplexEntities.FindAsync(someIdentifier);\n    }\n}