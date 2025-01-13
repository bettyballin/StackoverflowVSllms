public class CachingInterceptor : IInterceptor\n{\n    private readonly ICache _cache;\n\n    public CachingInterceptor(ICache cache)\n    {\n        _cache = cache;\n    }\n\n    public void Intercept(IInvocation invocation)\n    {\n        var cacheKey = invocation.Method.Name + "_GetAll";\n        var results = _cache.Get(cacheKey);\n        if (results == null)\n        {\n            invocation.Proceed();\n            results = invocation.ReturnValue;\n            _cache.Add(cacheKey, results);\n        }\n        invocation.ReturnValue = results;\n    }\n}