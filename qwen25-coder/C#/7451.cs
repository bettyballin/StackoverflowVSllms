// GET: /Controller/Friends\n[HttpGet]\npublic ActionResult Friends()\n{\n    // Handle GET request\n    return View();\n}\n\n// POST: /Controller/Friends\n[HttpPost]\npublic ActionResult Friends(YourModel model)\n{\n    // Handle POST request\n    return View(model);\n}