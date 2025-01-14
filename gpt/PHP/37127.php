<?php\nfunction setTimezoneByOffset($offset) {\n    $timezone = timezone_name_from_abbr("", $offset * 3600, false);\n    if ($timezone === false) {\n        // Handle case where timezone_name_from_abbr fails\n        throw new Exception("Invalid GMT offset");\n    }\n    $datetime = new DateTime();\n    $datetime->setTimezone(new DateTimeZone($timezone));\n    return $datetime;\n}\n\ntry {\n    $gmtOffset = -8.0; // Example GMT offset\n    $datetime = setTimezoneByOffset($gmtOffset);\n    echo $datetime->format('Y-m-d H:i:s T');\n} catch (Exception $e) {\n    echo "Error: " . $e->getMessage();\n}\n?>