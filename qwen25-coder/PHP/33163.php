// Set default timezone to UTC for consistency\ndate_default_timezone_set('UTC');\n\n// Storing data in MySQL\n$Date = new DateTime(); // Creates a new DateTime object with current date and time in UTC\n$dateTimeValueForDB = $Date->format('Y-m-d H:i:s'); // Format it as needed for MySQL\n\n// Assume this value gets inserted into your database...\n\n// Fetching from MySQL and Displaying\n$userTimezone = getUserTimeZoneFromCookie(); // Make sure to validate/sanitize this input\n$row['time'] = '2023-10-05 14:30:00'; // Example fetched datetime value, replace with your actual database call\n\n$Date = new DateTime($row['time'], new DateTimeZone('UTC')); // Create DateTime object in UTC timezone\n$Date->setTimezone(new DateTimeZone($userTimezone)); // Convert to user's timezone\n$displayDateTime = $Date->format('Y-m-d H:i:s'); // Format for display\n\necho "Post date and time: " . htmlspecialchars($displayDateTime);