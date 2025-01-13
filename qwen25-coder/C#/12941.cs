public ActionResult Test([FromBody] TestRequestModel model)\n{\n    if (model == null) return Json(new { success = false, error = "Invalid request" });\n\n    // Use model.Keyword as needed\n\n    return Json(new { Data = model.Keyword });\n}