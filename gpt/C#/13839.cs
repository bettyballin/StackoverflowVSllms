public class DownloadController : Controller\n    {\n        [AcceptVerbs(HttpVerbs.Get)]\n        public FilePathResult GetFile()\n        {\n            var fileName = @"c:\foo.exe";\n            return File(fileName, "application/octet-stream", "installer.exe");\n        }\n    }