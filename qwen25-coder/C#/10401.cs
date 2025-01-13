using System;\nusing System.Text;\nusing System.Web;\n\npublic static class CustomHtmlEncoder\n{\n    public static string EncodeToNumberedEntities(string input)\n    {\n        if (string.IsNullOrEmpty(input))\n        {\n            return string.Empty;\n        }\n\n        var sb = new StringBuilder();\n\n        foreach (char c in input)\n        {\n            if (c > 0x7F) // Characters beyond ASCII are encoded as numbered entities\n            {\n                sb.Append("&#" + ((int)c).ToString() + ";");\n            }\n            else\n            {\n                sb.Append(HttpUtility.HtmlEncode(c.ToString()));\n            }\n        }\n\n        return sb.ToString();\n    }\n}