public class MyController : Controller\n{\n    protected override void Dispose(bool disposing)\n    {\n        if (disposing)\n        {\n            // Free any other managed objects here.\n        }\n        base.Dispose(disposing);\n    }\n\n    public ActionResult Index()\n    {\n        return View();\n    }\n}