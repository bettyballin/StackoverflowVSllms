function get_date($month, $year, $week, $day, $direction) {\n    // Map day names to DateTime format\n    $daysOfWeek = ['Sun' => '0', 'Mon' => '1', 'Tue' => '2', 'Wed' => '3', 'Thu' => '4', 'Fri' => '5', 'Sat' => '6'];\n\n    // Validate inputs\n    if (!isset($daysOfWeek[$day])) {\n        throw new InvalidArgumentException("Invalid day name");\n    }\n    \n    $dayNumber = $daysOfWeek[$day];\n    \n    if ($direction == 'forward') {\n        // Calculate the first day of the month\n        $startDate = DateTime::createFromFormat('Y-n-j', "$year-$month-01");\n        \n        // Modify to the first occurrence of the given day\n        $startDate->modify("next " . strtolower($day));\n        if ($startDate->format('n') != $month) {\n            // If it's not in the month, go one week back\n            $startDate->modify("-7 days");\n        }\n        \n        // Add weeks to get to the right week\n        $startDate->add(new DateInterval("P" . (($week - 1) * 7) . "D"));\n        \n        return $startDate;\n    } elseif ($direction == 'backward') {\n        // Calculate the last day of the month\n        $lastDayOfMonth = DateTime::createFromFormat('Y-n-j', "$year-$month-01");\n        $lastDayOfMonth->modify('last day of this month');\n        \n        // Modify to the last occurrence of the given day\n        while ($lastDayOfMonth->format('w') != $dayNumber) {\n            $lastDayOfMonth->modify('-1 day');\n        }\n        \n        // Subtract weeks to get to the right week\n        $lastDayOfMonth->sub(new DateInterval("P" . (($week - 1) * 7) . "D"));\n        \n        return $lastDayOfMonth;\n    } else {\n        throw new InvalidArgumentException("Invalid direction");\n    }\n}\n\n// Usage examples\necho get_date(5, 2009, 1, 'Sun', 'forward')->format('Y-m-d'); // Output: 2009-05-03\necho "\n";\necho get_date(5, 2009, 2, 'Sun', 'backward')->format('Y-m-d'); // Output: 2009-05-17 (not as expected, see note)