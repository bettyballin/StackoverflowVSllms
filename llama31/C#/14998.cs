// Assume you have an Account model with a sensitive Id property\npublic class Account\n{\n    public int Id { get; set; } // sensitive data\n    public string NonSensitiveId { get; set; } // non-sensitive identifier\n}\n\n// In your controller, use the non-sensitive identifier in the URL\npublic class AccountsController : Controller\n{\n    public ActionResult Details(string nonSensitiveId)\n    {\n        var account = DbContext.Accounts.FirstOrDefault(a => a.NonSensitiveId == nonSensitiveId);\n        if (account != null)\n        {\n            return View(account);\n        }\n        return HttpNotFound();\n    }\n}