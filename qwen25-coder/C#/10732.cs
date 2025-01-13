[HttpPost]\npublic ActionResult YourActionMethod(YourViewModel model)\n{\n    // Ensure the hidden fields are correctly bound\n    string initialHour = model.InitialHour;\n    string finalHour = model.FinalHour;\n    string weekday = model.Weekday;\n\n    // Process the model and return the appropriate view\n\n    return View(model);\n}