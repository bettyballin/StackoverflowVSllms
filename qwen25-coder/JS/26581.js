function ClientValidationFunction(source, arguments) {\n    // Trim the input value\n    var trimmedValue = arguments.Value.trim();\n\n    // Check if the length of the trimmed string is within your desired range\n    if (trimmedValue.length >= 1 && trimmedValue.length <= 50) {\n        arguments.IsValid = true;\n    } else {\n        arguments.IsValid = false;\n    }\n}