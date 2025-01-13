public ActionResult YourAction()\n{\n    // Assume you have some logic to get the condition from the database\n    bool isVisible = GetVisibilityFromDatabase();\n\n    ViewBag.IsVisible = isVisible;\n\n    return View();\n}\n\nprivate bool GetVisibilityFromDatabase()\n{\n    // Your database logic to determine visibility\n    // For example:\n    return true; // or false, based on your condition\n}