// MVC Website\nusing LocalizationResources;\n\npublic class MyController : Controller\n{\n    public ActionResult MyAction()\n    {\n        string buttonText = Resources.GetResource("ButtonText_OK");\n        // Use buttonText in your view\n    }\n}