<?php\n// Event timestamp\n$eventTimestamp = "Sat Oct 25 21:55:29 +0000 2008";\n\n// Create DateTime objects for the event time and current time\n$eventTime = new DateTime($eventTimestamp);\n$currentTime = new DateTime();\n\n// Calculate the difference\n$interval = $currentTime->diff($eventTime);\n\n// Format the difference in a human-readable form\nif ($interval->y > 0) {\n    echo "It has been " . $interval->y . " year" . ($interval->y > 1 ? "s" : "") . "!";\n} elseif ($interval->m > 0) {\n    echo "It has been " . $interval->m . " month" . ($interval->m > 1 ? "s" : "") . "!";\n} elseif ($interval->d > 0) {\n    echo "It has been " . $interval->d . " day" . ($interval->d > 1 ? "s" : "") . "!";\n} elseif ($interval->h > 0) {\n    echo "It has been " . $interval->h . " hour" . ($interval->h > 1 ? "s" : "") . "!";\n} elseif ($interval->i > 0) {\n    echo "It has been " . $interval->i . " minute" . ($interval->i > 1 ? "s" : "") . "!";\n} else {\n    echo "It has been " . $interval->s . " second" . ($interval->s > 1 ? "s" : "") . "!";\n}\n?>