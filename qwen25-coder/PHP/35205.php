<?php\n\nfunction countWeekDays($startDate, $endDate) {\n    // Convert dates from string to DateTime objects\n    $start = new DateTime($startDate);\n    $end = new DateTime($endDate);\n\n    // Initialize weekdays counter\n    $weekdaysCount = 0;\n\n    // Iterate over each day between the two dates (inclusive)\n    for ($date = $start; $date <= $end; $date->modify('+1 day')) {\n        // Check if it's a weekday (Monday to Friday)\n        if ($date->format('N') <= 5) {\n            $weekdaysCount++;\n        }\n    }\n\n    return $weekdaysCount;\n}\n\n// Example usage\n$startDate = '2008-08-31';\n$endDate = '2008-09-13';\necho countWeekDays($startDate, $endDate); // Output: 10\n\n?>