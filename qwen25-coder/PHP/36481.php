// The UTC datetime stored in your database\n$utcDate = '2009-04-01 15:36:13';\n\n// Create a DateTime object from the UTC date\n$date = new DateTime($utcDate, new DateTimeZone('UTC'));\n\n// Set the desired timezone (e.g., America/Los_Angeles for PDT/PST)\n$timezone = new DateTimeZone('America/Los_Angeles');\n$date->setTimezone($timezone);\n\n// Format the date as needed\n$formattedDate = $date->format('Y-m-d H:i:s');\n\necho $formattedDate; // Outputs: 2009-04-01 08:36:13 during PDT, or 2009-04-01 07:36:13 during PST