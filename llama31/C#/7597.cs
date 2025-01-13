using System;\nusing System.Text.RegularExpressions;\n\npublic string SanitizeBase64(string base64String)\n{\n    // Remove whitespace and non-Base64 characters\n    base64String = base64String.Replace(" ", "").Replace("\r", "").Replace("\n", "");\n    base64String = Regex.Replace(base64String, @"[^-A-Za-z0-9+/=]", "");\n\n    // Check if the string is syntactically valid\n    if (!Regex.IsMatch(base64String, @"^[-A-Za-z0-9+/]*={0,3}$"))\n    {\n        throw new ArgumentException("Invalid Base64 string", nameof(base64String));\n    }\n\n    return base64String;\n}