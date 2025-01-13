using System.IO;\nusing System.Web.Mvc;\n\npublic class HomeController : Controller\n{\n    [HttpPost]\n    public ActionResult UploadFile(HttpPostedFileBase file)\n    {\n        if (file != null && file.ContentLength > 0)\n        {\n            var path = Path.Combine(Server.MapPath("~/Uploads"), Path.GetFileName(file.FileName));\n            file.SaveAs(path);\n        }\n\n        return Content("Success");\n    }\n}