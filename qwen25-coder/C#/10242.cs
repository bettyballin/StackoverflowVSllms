[HttpPost]\n   public ActionResult Edit(Candidate candidateToEdit)\n   {\n       if (ModelState.IsValid)\n       {\n           // Save changes\n           return RedirectToAction("Success");\n       }\n       \n       // If we got this far, something failed, redisplay form\n       return View(candidateToEdit);\n   }