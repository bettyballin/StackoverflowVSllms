public class BaseController : Controller\n{\n    private readonly ICacheProvider _cacheProvider;\n\n    public BaseController(ICacheProvider cacheProvider)\n    {\n        _cacheProvider = cacheProvider;\n    }\n\n    // ...\n}