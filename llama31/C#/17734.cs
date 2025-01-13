public class AutoCompleteController : Controller\n{\n  public ActionResult Index()\n  {\n    return View();\n  }\n\n  [HttpPost]\n  public JsonResult GetSuggestions(string prefixText)\n  {\n    var suggestions = new[] { "Apple", "Banana", "Cherry" };\n    return Json(suggestions.Where(s => s.StartsWith(prefixText)));\n  }\n}