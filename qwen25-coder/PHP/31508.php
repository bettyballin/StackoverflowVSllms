<?php\nfunction getUserTime($userTimezone) {\n    $date = new DateTime();\n    $date->setTimezone(new DateTimeZone($userTimezone));\n    return $date->format('Y-m-d H:i:s');\n}\n\n// Example usage: get time in User's timezone, e.g., 'America/New_York'\n$userTimezone = 'Europe/London'; // Replace with user's selected timezone\necho getUserTime($userTimezone);\n?>