[HttpPost]\n   public ActionResult ValidateAndProcess(MyModel model)\n   {\n       if (ModelState.IsValid)\n       {\n           // Process the request\n           return View("SuccessView", model);\n       }\n       else\n       {\n           // Return the same view with ModelState errors\n           return View(model);\n       }\n   }