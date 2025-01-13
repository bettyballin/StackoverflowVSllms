[AcceptVerbs(HttpVerbs.Post)]\npublic ActionResult UpdateNewsItem(int newsID, string newsTitle, string newsDescription, string newsBeginningDate, string newsEndingDate)\n{\n    // Clean user input\n    newsTitle = Models.clsGlobals.CleanString(newsTitle);\n    newsDescription = Models.clsGlobals.CleanParagraph(newsDescription);\n\n    // Validate inputs\n    if (string.IsNullOrEmpty(newsTitle))\n    {\n        ModelState.AddModelError("newsTitle", "You must enter a news title.");\n    }\n\n    if (string.IsNullOrEmpty(newsDescription))\n    {\n        ModelState.AddModelError("newsDescription", "You must enter a news description.");\n    }\n\n    DateTime dtBeginningDate;\n    if (!DateTime.TryParse(newsBeginningDate, out dtBeginningDate))\n    {\n        ModelState.AddModelError("newsBeginningDate", "Invalid date. Please use a format like '12/25/2008'.");\n    }\n\n    DateTime dtEndingDate;\n    if (!DateTime.TryParse(newsEndingDate, out dtEndingDate))\n    {\n        ModelState.AddModelError("newsEndingDate", "Invalid date. Please use a format like '12/25/2008'.");\n    }\n\n    // If the ModelState is not valid, return the errors as JSON\n    if (!ModelState.IsValid)\n    {\n        var errorList = ModelState.ToDictionary(\n            kvp => kvp.Key,\n            kvp => kvp.Value.Errors.Select(e => e.ErrorMessage).ToArray()\n        );\n\n        return Json(new { success = false, errors = errorList });\n    }\n\n    // Otherwise, proceed with updating the news item\n    // Your update logic here...\n\n    // If successful, return a success message\n    return Json(new { success = true, message = "News item updated successfully." });\n}