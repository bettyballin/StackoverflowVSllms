$utcDateTime = new DateTime($utcDateTimeString, new DateTimeZone('UTC'));\n$userTimeZone = new DateTimeZone($userTimeZoneString);\n$localDateTime = $utcDateTime->setTimezone($userTimeZone);\n\necho $localDateTime->format('Y-m-d H:i:s');