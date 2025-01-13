using System.IO;\n\npublic string GetMimeType(string fileName)\n{\n    var provider = new Microsoft.AspNetCore.StaticFiles.FileExtensionContentTypeProvider();\n    if (!provider.TryGetContentType(fileName, out string contentType))\n    {\n        contentType = "application/octet-stream";\n    }\n    return contentType;\n}