bool IsLetterOrDigit(char c)\n{\n    return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');\n}\n\n// Example usage\nstring input = "I_999Š=ÄÖÆaðøñòòñ";\nforeach (char c in input)\n{\n    if (!IsLetterOrDigit(c))\n    {\n        Console.WriteLine($"Corrupted character found: {c}");\n    }\n}