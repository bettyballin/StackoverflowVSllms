[HttpGet]\npublic ActionResult Login()\n{\n    return View();\n}\n\n[HttpPost]\npublic JsonResult Login(string username, string password, bool rememberMe)\n{\n    if (Membership.ValidateUser(username, password))\n    {\n        FormsAuthentication.SetAuthCookie(username, rememberMe);\n        return Json(new { success = true });\n    }\n\n    return Json(new { success = false, message = "Invalid credentials." });\n}