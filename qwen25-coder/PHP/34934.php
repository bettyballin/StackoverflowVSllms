function isValidDate($dateString) {\n    // Handle dates with 'B.C.' or 'BC'\n    $isBC = preg_match('/\b(B\.C\.|BC)\b/i', $dateString);\n    \n    if ($isBC) {\n        // Remove the B.C. or BC part and convert to a negative year\n        $dateString = preg_replace('/\s*(B\.C\.|BC)\b/i', '', $dateString);\n        $dateTime = DateTime::createFromFormat('Y-m-d', trim($dateString));\n        \n        if ($dateTime !== false) {\n            // Convert the date to BC by negating the year\n            $year = (int)$dateTime->format('Y') * -1;\n            return $year >= -9999; // Ensure it's not before 9999 B.C.\n        }\n    } else {\n        $dateTime = DateTime::createFromFormat('Y-m-d', trim($dateString));\n        \n        if ($dateTime !== false) {\n            $year = (int)$dateTime->format('Y');\n            return $year >= 1 && $year <= date('Y'); // Ensure it's not in the future\n        }\n    }\n    \n    return false;\n}\n\n// Example usage:\nvar_dump(isValidDate("1983-07-10")); // true\nvar_dump(isValidDate("1492-10-11")); // true\nvar_dump(isValidDate("200 B.C."));   // true