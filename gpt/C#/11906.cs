using System;\n\npublic class HomeController : Controller\n{\n    [HttpPost]\n    public ActionResult SubmitForm(string Name, string Email, string Message, string Honeypot, string FormStartTime)\n    {\n        // Check the honeypot field\n        if (!string.IsNullOrEmpty(Honeypot))\n        {\n            // Bot detected - take appropriate action (e.g., log, discard, etc.)\n            return new HttpStatusCodeResult(400, "Bot detected");\n        }\n\n        // Check the time taken to submit the form\n        if (DateTime.TryParse(FormStartTime, out DateTime formStart) && (DateTime.Now - formStart).TotalSeconds < 5)\n        {\n            // Form submitted too quickly - likely a bot\n            return new HttpStatusCodeResult(400, "Bot detected");\n        }\n\n        // Process the form data\n        // ...\n\n        return RedirectToAction("ThankYou");\n    }\n\n    public ActionResult ThankYou()\n    {\n        return View();\n    }\n}