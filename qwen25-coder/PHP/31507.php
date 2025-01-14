<?php\n// Create a new DateTime object for the current date and time\n$date = new DateTime();\n\n// Set the timezone of the DateTime object to GMT\n$date->setTimezone(new DateTimeZone('GMT'));\n\n// Format the date as needed, e.g., Y-m-d H:i:s\necho $date->format('Y-m-d H:i:s');\n?>