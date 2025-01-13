using StackExchange.Redis;\nusing System;\n\npublic class RedisCache\n{\n    private readonly IDatabase _cache;\n\n    public RedisCache(string connectionString)\n    {\n        var connection = ConnectionMultiplexer.Connect(connectionString);\n        _cache = connection.GetDatabase();\n    }\n\n    public void Set(string key, string value, TimeSpan expiry)\n    {\n        _cache.StringSet(key, value, expiry);\n    }\n\n    public string Get(string key)\n    {\n        return _cache.StringGet(key);\n    }\n}\n\n// Usage\nvar redisCache = new RedisCache("localhost:6379");\nredisCache.Set("key1", "value1", TimeSpan.FromMinutes(10));\nstring value = redisCache.Get("key1");\nConsole.WriteLine(value);