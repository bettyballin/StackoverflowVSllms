using xVal;\n\npublic class User\n{\n    [Required]\n    public string Username { get; set; }\n\n    [EmailAddress]\n    public string Email { get; set; }\n}\n\npublic class UserController : Controller\n{\n    public ActionResult Create(User user)\n    {\n        try\n        {\n            user.Validate();\n            // Save user to database\n        }\n        catch (ValidationException ex)\n        {\n            ModelState.AddModelError(ex.Message);\n        }\n        return View();\n    }\n}