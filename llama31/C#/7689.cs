using System.IO;\n\npublic bool IsImage(string filePath)\n{\n    var mimeType = GetMimeType(filePath);\n    return mimeType.StartsWith("image/");\n}\n\npublic string GetMimeType(string filePath)\n{\n    var fileInfo = new FileInfo(filePath);\n    return MimeMapping.GetMimeMapping(fileInfo.Name);\n}