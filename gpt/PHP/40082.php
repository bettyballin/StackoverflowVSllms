<?php\n// Create a new DateTime object\n$date = new DateTime('now', new DateTimeZone('GMT'));\n\n// Format the date/time to your desired format, e.g., 'Y-m-d H:i:s'\necho $date->format('Y-m-d H:i:s');\n?>