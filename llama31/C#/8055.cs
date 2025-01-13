public class MyController : Controller\n{\n    public ActionResult Index()\n    {\n        ViewBag.Countries = new SelectList(db.Countries.ToList(), "Id", "Name");\n        return View();\n    }\n\n    public JsonResult GetRegions(int countryId)\n    {\n        var regions = db.Regions.Where(r => r.CountryId == countryId).ToList();\n        return Json(new SelectList(regions, "Id", "Name"));\n    }\n}