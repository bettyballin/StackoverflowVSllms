using System.Text;\n\npublic string Reverse(string text)\n{\n    char[] cArray = text.ToCharArray();\n    StringBuilder reverse = new StringBuilder(cArray.Length);\n    for (int i = cArray.Length - 1; i >= 0; i--)\n    {\n        reverse.Append(cArray[i]);\n    }\n    return reverse.ToString();\n}