[PopulateModelBaseDataActionFilter]\npublic class ProductController : MySiteControllerBase\n{\n    public ActionResult Index()\n    {\n        var model = new ProductModel();\n        return View(model);\n    }\n}