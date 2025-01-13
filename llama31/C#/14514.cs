public class PrefixModelCacheKeyFactory : IModelCacheKeyFactory\n{\n    private readonly string _prefix;\n\n    public PrefixModelCacheKeyFactory(string prefix)\n    {\n        _prefix = prefix;\n    }\n\n    public object Create(DbContext context)\n    {\n        return new PrefixModelCacheKey(_prefix, context);\n    }\n}\n\npublic class PrefixModelCacheKey\n{\n    public string Prefix { get; }\n    public DbContext Context { get; }\n\n    public PrefixModelCacheKey(string prefix, DbContext context)\n    {\n        Prefix = prefix;\n        Context = context;\n    }\n}