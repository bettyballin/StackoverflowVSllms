public ActionResult Create()\n{\n    var model = new ServerAccessModel();\n    // Populate AvailableServerList with items\n    // Example:\n    model.AvailableServerList.Add(new SelectListItem { Text = "Server1", Value = "1" });\n    // Add other servers as needed\n\n    return View(model);\n}