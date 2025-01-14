// Example PHP validation function\nfunction validateForm($formData) {\n    $xml = simplexml_load_file('validation-rules.xml');\n    foreach ($formData as $key => $value) {\n        if (isset($xml->Field["$key"])) {\n            $fieldRules = $xml->Field["$key"];\n\n            if ((string)$fieldRules->Required === "true" && empty($value)) {\n                echo "$key is required.\n";\n                return false;\n            }\n\n            if (isset($fieldRules->MinLength) && strlen($value) < (int)$fieldRules->MinLength) {\n                echo "$key must be at least " . (int)$fieldRules->MinLength . " characters long.\n";\n                return false;\n            }\n\n            if (isset($fieldRules->MaxLength) && strlen($value) > (int)$fieldRules->MaxLength) {\n                echo "$key cannot exceed " . (int)$fieldRules->MaxLength . " characters.\n";\n                return false;\n            }\n\n            if (isset($fieldRules->Pattern) && !preg_match('/^' . $fieldRules->Pattern . '$/', $value)) {\n                echo "$key does not match required format.\n";\n                return false;\n            }\n        }\n    }\n    return true;\n}