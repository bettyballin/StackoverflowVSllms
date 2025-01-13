[HttpPost]\n     public ActionResult Login(string username, string password)\n     {\n         if (_userService.ValidateLogin(username, password))\n         {\n             // Successful login logic...\n         }\n         else\n         {\n             ModelState.AddModelError("Username", "Invalid username or password.");\n             return View();\n         }\n     }