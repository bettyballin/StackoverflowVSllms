using System.Web.Mvc;\n\npublic class HomeController : Controller\n{\n    [HttpPost]\n    public ActionResult PageB(string myData)\n    {\n        // Process the data received from PageA\n        ViewBag.MyData = myData;\n        return View();\n    }\n}