public class HomeController : Controller\n{\n    public JsonResult GetData()\n    {\n        var data = new { Message = "Hello, AJAX!" };\n        return Json(data, JsonRequestBehavior.AllowGet);\n    }\n}