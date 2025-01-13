<?php\nrequire 'vendor/autoload.php';\n\nuse Respect\Validation\Validator as v;\n\n// Basic validation: string length\n$stringValidator = v::stringType()->length(1, 255);\n$isValidString = $stringValidator->validate('example string'); // true or false\n\n// Complex validation: strip <> tags\n$input = '<h1>Title</h1>';\n$sanitizedInput = strip_tags($input);\n$isValidSanitized = $stringValidator->validate($sanitizedInput); // true or false\n\n// Custom validation: email\n$emailValidator = v::email();\n$isValidEmail = $emailValidator->validate('example@example.com'); // true or false\n\nif ($isValidString && $isValidSanitized && $isValidEmail) {\n    echo "All validations passed.";\n} else {\n    echo "Validation failed.";\n}\n?>