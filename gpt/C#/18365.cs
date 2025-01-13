public static bool IsAValidWholeNumber(string questionalWholeNumber)\n{\n    if (string.IsNullOrWhiteSpace(questionalWholeNumber))\n    {\n        return true;\n    }\n\n    int result;\n    return int.TryParse(questionalWholeNumber, out result);\n}