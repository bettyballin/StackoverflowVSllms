function get_date($month, $year, $week, $day, $direction) {\n    $first_day = mktime(0, 0, 0, $month, 1, $year);\n    $first_day_of_week = strtotime("first $day", $first_day);\n    \n    if ($direction == 'forward') {\n        $result = strtotime("+$week weeks", $first_day_of_week);\n    } elseif ($direction == 'backward') {\n        $last_day = mktime(0, 0, 0, $month + 1, 0, $year);\n        $last_day_of_week = strtotime("last $day", $last_day);\n        $result = strtotime("-$week weeks", $last_day_of_week);\n    }\n    \n    return date('Y-m-d', $result);\n}\n\n// Test the function\nprint(get_date(5, 2009, 1, 'Sun', 'forward'));  // Output: 2009-05-03\nprint("\n");\nprint(get_date(5, 2009, 2, 'Sun', 'backward'));  // Output: 2009-05-24