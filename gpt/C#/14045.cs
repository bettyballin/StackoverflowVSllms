public class YourController : Controller\n    {\n        [HttpGet]\n        public ActionResult Create()\n        {\n            return View();\n        }\n\n        [HttpPost]\n        [ValidateAntiForgeryToken]\n        public ActionResult Create(RegistrationViewModel model)\n        {\n            if (ModelState.IsValid)\n            {\n                // Map ViewModel to your domain model and save to the database\n                // var user = new User { ... };\n                // db.Users.Add(user);\n                // db.SaveChanges();\n\n                return RedirectToAction("Index"); // Or some other action\n            }\n\n            return View(model);\n        }\n    }