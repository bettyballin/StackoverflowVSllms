// In your controller, ensure you're adding counties to ViewBag/ViewData correctly\npublic ActionResult YourAction()\n{\n    var counties = new SelectList(new[]\n    {\n        new { Id = "Lander", Name = "Lander" },\n        new { Id = "Laramie", Name = "Laramie" },\n        new { Id = "Larimer", Name = "Larimer" }\n    }, "Id", "Name", "Laramie"); // The last parameter sets the selected value\n\n    ViewBag.Counties = counties;\n    return View();\n}