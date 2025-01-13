function getBusinessWeeks($startDate, $endDate) {\n    $start = new DateTime($startDate);\n    $end = new DateTime($endDate);\n    $weeks = array();\n\n    while ($start <= $end) {\n        $weekStart = clone $start;\n        $weekEnd = clone $start;\n        $weekEnd->modify('+4 days');\n\n        if ($weekEnd > $end) {\n            $weekEnd = $end;\n        }\n\n        $weeks[] = $weekStart->format('M j') . ' - ' . $weekEnd->format('M j');\n\n        $start->modify('+7 days');\n    }\n\n    return $weeks;\n}\n\n$startDate = '02-03-2009';\n$endDate = '31-12-2010';\n\n$businessWeeks = getBusinessWeeks($startDate, $endDate);\n\nforeach ($businessWeeks as $week) {\n    echo $week . "\n";\n}