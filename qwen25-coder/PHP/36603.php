<?php\nfunction getCurrentTimeInTimeZone($offsetHours) {\n    // Get current GMT time\n    $gmDate = gmdate("Y-m-d H:i:s");\n\n    // Convert GMT to desired timezone using a manual offset\n    $timeParts = explode(' ', $gmDate);\n    list($year, $month, $day) = explode('-', $timeParts[0]);\n    list($hour, $minute, $second) = explode(':', $timeParts[1]);\n\n    // Create a timestamp from GMT time\n    $ts = gmmktime($hour, $minute, $second, $month, $day, $year);\n\n    // Add or subtract the offset (in seconds)\n    $offsetSeconds = $offsetHours * 3600;\n    $localTs = $ts + $offsetSeconds;\n\n    return date("Y-m-d H:i:s", $localTs);\n}\n\n// Example usage: Get current time in a timezone with an offset of -5 hours\necho getCurrentTimeInTimeZone(-5); // Eastern Standard Time (EST)