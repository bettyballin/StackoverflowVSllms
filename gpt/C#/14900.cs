// Business Logic Layer (n-tier)\npublic class BusinessService\n{\n    public List<string> GetData()\n    {\n        // Business logic to retrieve data\n        return new List<string> { "Data1", "Data2", "Data3" };\n    }\n}\n\n// MVC Model\npublic class MyViewModel\n{\n    public List<string> Data { get; set; }\n}\n\n// MVC Controller\npublic class MyController : Controller\n{\n    private readonly BusinessService _businessService;\n\n    public MyController()\n    {\n        _businessService = new BusinessService();\n    }\n\n    public ActionResult Index()\n    {\n        // Use the business service to get data\n        List<string> data = _businessService.GetData();\n\n        // Populate the view model\n        MyViewModel model = new MyViewModel\n        {\n            Data = data\n        };\n\n        // Pass the model to the view\n        return View(model);\n    }\n}