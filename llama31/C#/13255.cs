public class MyController : Controller\n{\n    public async Task<ActionResult> MyAction()\n    {\n        // Perform database query or other operation\n        var data = await MyService.GetDataAsync();\n        return Json(data);\n    }\n}