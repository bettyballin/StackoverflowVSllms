<%@ WebHandler Language="C#" Class="UploadHandler" %>\n\nusing System;\nusing System.Web;\nusing System.IO;\n\npublic class UploadHandler : IHttpHandler {\n\n    public void ProcessRequest(HttpContext context) {\n        context.Response.ContentType = "text/plain";\n\n        if (context.Request.Files.Count > 0) {\n            HttpPostedFile file = context.Request.Files[0];\n            string folderPath = context.Server.MapPath("~/UploadedImages/");\n            if (!Directory.Exists(folderPath)) {\n                Directory.CreateDirectory(folderPath);\n            }\n            string filePath = Path.Combine(folderPath, Path.GetFileName(file.FileName));\n            file.SaveAs(filePath);\n            context.Response.Write("File uploaded successfully");\n        } else {\n            context.Response.Write("No file received");\n        }\n    }\n\n    public bool IsReusable {\n        get {\n            return false;\n        }\n    }\n}