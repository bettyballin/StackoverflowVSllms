public class MyController : Controller\n{\n    public string GetPageAsString()\n    {\n        var model = new SomeModel(); // Your model\n        var viewString = ViewHelper.RenderViewToString(this.ControllerContext, \n                                                      "MyView", \n                                                      "~/Views/Shared/_Layout.cshtml", \n                                                      model);\n        return viewString;\n    }\n}