$months = array();\n$currentMonth = date('n'); // get the current month (1-12)\n$currentYear = date('Y'); // get the current year\n\nfor ($x = 0; $x < 12; $x++) {\n    $month = mktime(0, 0, 0, $currentMonth + $x, 1, $currentYear); // set day to 1\n    $key = date('m', $month);\n    $monthname = date('F', $month);\n    $months[$key] = $monthname;\n}