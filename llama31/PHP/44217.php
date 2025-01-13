function getTimeInTimezone($timezoneName) {\n    $dateTime = new DateTime('now', new DateTimeZone($timezoneName));\n    return $dateTime->format("Y-m-d H:i:s");\n}\n\n// Example usage:\necho getTimeInTimezone('America/New_York');