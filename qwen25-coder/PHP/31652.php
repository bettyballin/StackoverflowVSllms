<?php\nfunction getDayOfCurrentQuarter() {\n    $currentDate = new DateTime();\n    $firstDayOfQuarter = clone $currentDate;\n    \n    // Set the date to the first day of the current quarter\n    switch ($currentDate->format('m')) {\n        case 1:\n        case 2:\n        case 3:\n            $firstDayOfQuarter->setDate($currentDate->format('Y'), 1, 1);\n            break;\n        case 4:\n        case 5:\n        case 6:\n            $firstDayOfQuarter->setDate($currentDate->format('Y'), 4, 1);\n            break;\n        case 7:\n        case 8:\n        case 9:\n            $firstDayOfQuarter->setDate($currentDate->format('Y'), 7, 1);\n            break;\n        case 10:\n        case 11:\n        case 12:\n            $firstDayOfQuarter->setDate($currentDate->format('Y'), 10, 1);\n            break;\n    }\n    \n    // Calculate the difference in days\n    $interval = $firstDayOfQuarter->diff($currentDate);\n    \n    // Add 1 because the day count should start from 1, not 0\n    return $interval->days + 1;\n}\n\necho getDayOfCurrentQuarter(); // Outputs the day number of the current quarter\n?>