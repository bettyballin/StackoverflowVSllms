// Example of simple ASP.NET Core controller to receive image\nusing Microsoft.AspNetCore.Mvc;\nusing System.IO;\n\n[ApiController]\npublic class UploadController : ControllerBase\n{\n    [HttpPost("/upload-image")]\n    public IActionResult UploadImage()\n    {\n        if (Request.Form.Files["image"] != null)\n        {\n            var uploadedFile = Request.Form.Files["image"];\n            var filePath = Path.Combine("wwwroot/uploads", uploadedFile.FileName);\n            \n            using (var fileStream = new FileStream(filePath, FileMode.Create))\n            {\n                uploadedFile.CopyTo(fileStream);\n            }\n\n            return Ok($"Image saved as {uploadedFile.FileName}");\n        }\n        \n        return BadRequest();\n    }\n}