public class HomeController : Controller\n{\n    // This action will be accessible via HTTP\n    public ActionResult Index()\n    {\n        return View();\n    }\n\n    // This action will be forced to use HTTPS\n    [RequireHttpsCustom]\n    public ActionResult SecureAction()\n    {\n        return View();\n    }\n}