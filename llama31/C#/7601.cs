using System.Drawing;\n\npublic bool IsImage(string filePath)\n{\n    try\n    {\n        using (var img = Image.FromFile(filePath))\n        {\n            return true;\n        }\n    }\n    catch\n    {\n        return false;\n    }\n}