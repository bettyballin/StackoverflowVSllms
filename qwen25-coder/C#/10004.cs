public class HomeController : Controller {\n      public ActionResult Index() {\n          ViewBag.Message = "Welcome to ASP.NET MVC!";\n          return View();\n      }\n  }