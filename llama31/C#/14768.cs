[HttpPost]\npublic ActionResult Upload(HttpPostedFileBase file, string token)\n{\n    if (ModelState.IsValid && ValidateToken(token))\n    {\n        // Process the uploaded file\n        // ...\n    }\n    else\n    {\n        // Handle invalid token or request\n    }\n}\n\nprivate bool ValidateToken(string token)\n{\n    return token == HttpContext.Request.Form["token"];\n}