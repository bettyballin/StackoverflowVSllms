[HttpPost]\npublic ActionResult Test()\n{\n    string keyword = Request.Form["keyword"];\n    return Json(new { Data = keyword });\n}