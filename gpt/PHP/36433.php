<?php\nfunction getBusinessWeeks($startDate, $endDate) {\n    $start = DateTime::createFromFormat('d-m-Y', $startDate);\n    $end = DateTime::createFromFormat('d-m-Y', $endDate);\n    $interval = new DateInterval('P1D');\n    $dateRange = new DatePeriod($start, $interval, $end->modify('+1 day'));\n\n    $weeks = [];\n    $currentWeek = [];\n\n    foreach ($dateRange as $date) {\n        if ($date->format('N') >= 1 && $date->format('N') <= 5) { // Monday to Friday\n            $currentWeek[] = $date;\n        }\n\n        if (count($currentWeek) == 5) {\n            $weeks[] = $currentWeek;\n            $currentWeek = [];\n        }\n    }\n\n    // In case the last week is not complete\n    if (!empty($currentWeek)) {\n        $weeks[] = $currentWeek;\n    }\n\n    foreach ($weeks as $week) {\n        $start = $week[0]->format('M j');\n        $end = end($week)->format('M j');\n        echo "$start - $end\n";\n    }\n}\n\n$startDate = '02-03-2009';\n$endDate = '31-12-2010';\ngetBusinessWeeks($startDate, $endDate);\n?>