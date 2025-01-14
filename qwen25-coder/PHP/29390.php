function getNthWeekday($year, $month, $weekday, $n) {\n    // Initialize DateTime object for the first day of the month\n    $date = new DateTime("$year-$month-01");\n    \n    // Set to the first occurrence of the weekday in the month\n    $date->modify('first ' . $weekday . ' of this month');\n    \n    // If n is greater than 1, iterate to find nth occurrence\n    for ($i = 1; $i < $n; $i++) {\n        $date->modify('+1 week');\n    }\n    \n    return $date;\n}\n\n// Example usage:\n$nthTuesday = getNthWeekday(2009, 6, 'tuesday', 1);\necho "First Tuesday of June 2009: " . $nthTuesday->format('Y-m-d') . "\n";\n\n$nthFriday = getNthWeekday(2009, 6, 'friday', 2);\necho "Second Friday of June 2009: " . $nthFriday->format('Y-m-d') . "\n";