public class HomeController : Controller\n{\n    public ActionResult Index()\n    {\n        var model = new HomeModel { Greeting = "Hello, user!" };\n        return View(model);\n    }\n}