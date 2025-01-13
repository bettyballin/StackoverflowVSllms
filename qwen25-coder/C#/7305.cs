public List<string> ParseCsvLine(ReadOnlySpan<char> line)\n{\n    var values = new List<string>();\n    StringBuilder currentString = new StringBuilder();\n    bool inQuotes = false;\n\n    for (int i = 0; i < line.Length; i++)\n    {\n        char c = line[i];\n\n        if (c == '"')\n        {\n            inQuotes = !inQuotes;\n            continue;\n        }\n\n        if (!inQuotes && c == ',')\n        {\n            values.Add(currentString.ToString());\n            currentString.Clear();\n            continue;\n        }\n\n        currentString.Append(c);\n    }\n\n    // Add the last StringBuilder content as a value\n    values.Add(currentString.ToString());\n\n    return values;\n}