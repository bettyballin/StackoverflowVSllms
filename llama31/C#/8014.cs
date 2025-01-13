using System.Web.Hosting;\n\npublic abstract class BaseController : Controller\n{\n    public BaseController()\n    {\n        string filePath = HostingEnvironment.MapPath("~/Content/Xml/Buttons.xml");\n        XDocument buttonsXmlDoc = XDocument.Load(filePath);\n    }\n}