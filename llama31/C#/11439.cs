public class HomeController : Controller\n{\n    public ActionResult Index()\n    {\n        List<ContactView> contacts = new List<ContactView>\n        {\n            new ContactView { Name = "John Doe", Email = "john.doe@example.com" },\n            new ContactView { Name = "Jane Doe", Email = "jane.doe@example.com" }\n        };\n        return View(contacts);\n    }\n}