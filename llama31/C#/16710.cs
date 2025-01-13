using System.Text.RegularExpressions;\n\npublic static Boolean TryStrToGuid(String s, out Guid value)\n{\n    const string GuidRegex = @"^[{(]?[0-9a-fA-F]{8}[-]?([0-9a-fA-F]{4}[-]?){3}[0-9a-fA-F]{12}[)}]?$";\n\n    if (Regex.IsMatch(s, GuidRegex))\n    {\n        try\n        {\n            value = new Guid(s);\n            return true;\n        }\n        catch (FormatException)\n        {\n            value = Guid.Empty;\n            return false;\n        }\n    }\n    else\n    {\n        value = Guid.Empty;\n        return false;\n    }\n}