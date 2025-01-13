public class YourController : Controller\n{\n    [HttpGet]\n    public ActionResult YourForm()\n    {\n        var model = new DynamicFormViewModel\n        {\n            StringDateCombos = new List<StringDateCombo> { new StringDateCombo() } // Initialize with at least one item\n        };\n\n        return View(model);\n    }\n\n    [HttpPost]\n    public ActionResult YourForm(DynamicFormViewModel model)\n    {\n        if (ModelState.IsValid)\n        {\n            // Process the data\n        }\n\n        // Return the view with validation errors\n        return View(model);\n    }\n}