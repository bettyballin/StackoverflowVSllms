// PageA\n[HttpPost]\npublic ActionResult SubmitForm(FormCollection form)\n{\n    TempData["PageAData"] = form;\n    return RedirectToAction("PageB");\n}\n\n// PageB\npublic ActionResult PageB()\n{\n    var data = TempData["PageAData"];\n    // Use the data\n}