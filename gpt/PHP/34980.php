<?php\nfunction gaussian($mean, $stdDev) {\n    $x = mt_rand() / mt_getrandmax();\n    $y = mt_rand() / mt_getrandmax();\n    \n    $z = sqrt(-2 * log($x)) * cos(2 * M_PI * $y);\n    \n    return $mean + $z * $stdDev;\n}\n\nfunction generateGaussianPoints($meanHour, $stdDevHour, $numPoints) {\n    $points = [];\n    for ($i = 0; $i < $numPoints; $i++) {\n        $hour = gaussian($meanHour, $stdDevHour);\n        \n        // Ensure the hour is within the 0-24 range\n        $hour = fmod($hour + 24, 24);\n        \n        $points[] = $hour;\n    }\n    return $points;\n}\n\n$meanHour = 10; // Peak at 10 o'clock\n$stdDevHour = 2; // Standard deviation\n$numPoints = 100; // Number of points to generate\n\n$points = generateGaussianPoints($meanHour, $stdDevHour, $numPoints);\n\nprint_r($points);\n?>