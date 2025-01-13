public ActionResult Create(Person personToCreate)\n{\n    if (ModelState.IsValid)\n    {\n        // Process the person object here, e.g., saving to a database.\n        return Json(new { success = true });\n    }\n\n    return Json(new { success = false, errors = ModelState.Keys.SelectMany(k => ModelState[k].Errors).Select(m => m.ErrorMessage) });\n}