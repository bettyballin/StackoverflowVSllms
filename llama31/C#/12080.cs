private int CalculatePasswordComplexity(string password)\n{\n    int complexity = 0;\n\n    // Length\n    complexity += password.Length / 4; // rewards longer passwords\n\n    // Character diversity\n    int charClasses = 0;\n    if (password.Any(c => char.IsDigit(c))) charClasses++;\n    if (password.Any(c => char.IsLetter(c))) charClasses++;\n    if (password.Any(c => char.IsUpper(c))) charClasses++;\n    if (password.Any(c => char.IsPunctuation(c))) charClasses++;\n    complexity += charClasses;\n\n    // Uncommon characters\n    int uncommonChars = 0;\n    foreach (char c in password)\n    {\n        if (!char.IsLetterOrDigit(c) && !char.IsPunctuation(c))\n        {\n            uncommonChars++;\n        }\n    }\n    complexity += uncommonChars / 2; // rewards uncommon characters\n\n    // Sequence and pattern detection\n    // (this is a basic example and can be improved)\n    string[] commonSequences = { "qwerty", "123456", "abc123" };\n    if (commonSequences.Any(seq => password.Contains(seq)))\n    {\n        complexity -= 2; // penalizes common sequences\n    }\n\n    return complexity;\n}