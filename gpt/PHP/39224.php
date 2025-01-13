function dateTimeFormat($dateIn)\n{\n    // Split the date and time parts\n    $dateTimeParts = explode(" ", $dateIn);\n\n    // Ensure $dateTimeParts has both date and time\n    if (count($dateTimeParts) != 2) {\n        return "Invalid date format";\n    }\n\n    // Split the date part\n    $dateParts = explode("-", $dateTimeParts[0]);\n    // Split the time part\n    $timeParts = explode(":", $dateTimeParts[1]);\n\n    // Ensure all parts are available\n    if (count($dateParts) != 3 || count($timeParts) < 2) {\n        return "Invalid date format";\n    }\n\n    // Assign date parts\n    $year = (int)$dateParts[0];\n    $month = (int)$dateParts[1];\n    $day = (int)$dateParts[2];\n    // Assign time parts\n    $hour = (int)$timeParts[0];\n    $min = (int)$timeParts[1];\n\n    // Create the formatted date string\n    $dateOut = date("F j, Y g:i A", mktime($hour, $min, 0, $month, $day, $year));\n\n    return $dateOut;\n}