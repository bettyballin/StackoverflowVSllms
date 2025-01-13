// Example of an MVC Controller Action Method\npublic class HomeController : Controller\n{\n    public ActionResult Index()\n    {\n        return View();\n    }\n\n    // Using JsonResult to return data in JSON format for AJAX calls\n    public JsonResult GetData()\n    {\n        var data = new { Message = "Hello, World!" };\n        return Json(data, JsonRequestBehavior.AllowGet);\n    }\n}