using System.Security;\n\npublic static string Escape(string input)\n{\n    return SecurityElement.Escape(input);\n}