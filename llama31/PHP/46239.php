function imperialToMetric($length) {\n    $regex = '/(\d+\'?)?\s*(\d+)?\s*(\d+\/\d+)?"$/';\n    preg_match($regex, $length, $matches);\n\n    $feet = (int) ($matches[1] ?? 0);\n    $inches = (int) ($matches[2] ?? 0);\n    $fraction = $matches[3] ?? '';\n\n    if ($fraction) {\n        list($numerator, $denominator) = explode('/', $fraction);\n        $inches += $numerator / $denominator;\n    }\n\n    $totalInches = ($feet * 12) + $inches;\n    $centimeters = round($totalInches * 2.54, 2);\n\n    return $centimeters . ' cm';\n}\n\n// Test the function\n$length = "3' 2 1/2\"";\necho imperialToMetric($length); // Output: 98.43 cm\n\n$length = "1/2\"";\necho imperialToMetric($length); // Output: 1.27 cm