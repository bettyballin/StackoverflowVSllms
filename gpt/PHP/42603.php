// Convert local time to UTC before storing\n   $localTime = new DateTime('now', new DateTimeZone('America/New_York'));\n   $utcTime = $localTime->setTimezone(new DateTimeZone('UTC'));\n   $utcTimeString = $utcTime->format('Y-m-d H:i:s');\n   \n   // Store $utcTimeString in the database