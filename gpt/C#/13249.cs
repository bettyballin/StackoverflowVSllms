public ActionResult Edit(int id)\n{\n    var product = productsRepository.GetProduct(id);\n\n    if (product == null)\n    {\n        return View("NotFound", new MasterViewModel());\n    }\n\n    return View(ContentViewModel.Create(product));\n}\n\n[HttpPost, ValidateInput(false)]\npublic ActionResult Edit(int id, FormCollection formCollection)\n{\n    var product = productsRepository.GetProduct(id);\n\n    if (formCollection["btnSave"] != null)\n    {\n        if (TryUpdateModel(product))\n        {\n            if (TryUpdateModel(product.Images, "images"))\n            {\n                productsRepository.Save();\n                return RedirectToAction("Details", new { id = product.ID });\n            }\n        }\n\n        return View(ContentViewModel.Create(product));\n    }\n\n    return RedirectToAction("Details", new { id = product.ID });\n}