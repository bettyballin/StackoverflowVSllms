public ActionResult YourAction()\n{\n    var counties = new List<SelectListItem>\n    {\n        new SelectListItem { Value = "Lander", Text = "Lander" },\n        new SelectListItem { Value = "Laramie", Text = "Laramie" },\n        new SelectListItem { Value = "Larimer", Text = "Larimer" }\n    };\n\n    ViewBag.Counties = counties;\n    var model = new YourViewModel\n    {\n        // Set the selected county here\n        Invoice = new InvoiceModel { County = "Laramie" }\n    };\n\n    return View(model);\n}