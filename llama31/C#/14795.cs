[HttpPost]\npublic ActionResult StoreLocation(string location)\n{\n    // Store the location in the user's session\n    Session["UserLocation"] = location;\n    return Json(new { success = true });\n}