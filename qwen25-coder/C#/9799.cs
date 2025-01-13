public abstract class BaseController : Controller\n{\n    protected new HttpContextBase HttpContext => (HttpContext ?? new HttpContextWrapper(System.Web.HttpContext.Current));\n\n    public virtual ActionResult Index()\n    {\n        var request = HttpContext.Request;\n        // Process the request using abstractions\n        return View();\n    }\n}