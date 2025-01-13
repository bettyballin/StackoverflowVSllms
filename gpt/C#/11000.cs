public ActionResult ExternalLogin(LoginViewModel model)\n   {\n       if (ModelState.IsValid)\n       {\n           if (IsInternalNetwork())\n           {\n               return RedirectToAction("Login", "Account");\n           }\n           else\n           {\n               // External login logic\n           }\n       }\n       return View(model);\n   }\n\n   private bool IsInternalNetwork()\n   {\n       // Implement logic to check if the user is on the internal network\n       return Request.IsLocal;\n   }