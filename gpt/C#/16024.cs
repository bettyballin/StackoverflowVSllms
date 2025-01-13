using System.Web;\nusing System.Web.Mvc;\n\npublic class YourController : Controller\n{\n    [HttpPost]\n    public ActionResult YourAction(string textInput1, string textInput2, HttpPostedFileBase fileInput)\n    {\n        if (fileInput != null && fileInput.ContentLength > 0)\n        {\n            // Save the file or process it\n            var path = Server.MapPath("~/Uploads/" + fileInput.FileName);\n            fileInput.SaveAs(path);\n        }\n\n        // Return a response\n        return Json(new { success = true });\n    }\n}