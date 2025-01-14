function getWeekRange($referenceDate) {\n    $date = new DateTime($referenceDate);\n    \n    // Set ISO-8601 week date (Monday as the week start), then subtract 1 day to get Sunday\n    $date->setISODate((int)$date->format('o'), (int)$date->format('W') - 1, 7);\n    $startDate = $date->format('Y-m-d');\n    \n    // Add 6 days to the start date to get the end date (Saturday)\n    $date->modify('+6 days');\n    $endDate = $date->format('Y-m-d');\n    \n    return [$startDate, $endDate];\n}\n\n// Example usage:\n$referenceDate = '2009-05-01';\nlist($start, $end) = getWeekRange($referenceDate);\necho "Start: $start\nEnd: $end\n"; // Output: Start: 2009-04-26 End: 2009-05-02\n\n$referenceDate = '2009-05-10';\nlist($start, $end) = getWeekRange($referenceDate);\necho "Start: $start\nEnd: $end\n"; // Output: Start: 2009-05-10 End: 2009-05-16